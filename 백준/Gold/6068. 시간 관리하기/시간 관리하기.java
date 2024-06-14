import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Job {
	int cost;
	int limit;

	public Job(int cost, int limit) {
		this.cost = cost;
		this.limit = limit;
	}
}

public class Main {
	public static int n;
	public static int pointer;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> j2.limit - j1.limit);

		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");

			int cost = Integer.parseInt(s[0]);
			int limit = Integer.parseInt(s[1]);
			pq.add(new Job(cost, limit));
		}

		Job firstJob = pq.poll();
		pointer = firstJob.limit - firstJob.cost;

		while (!pq.isEmpty()) {
			Job currentJob = pq.poll();
			if (currentJob.limit < pointer) {
				pointer = currentJob.limit - currentJob.cost;
			} else {
				pointer -= currentJob.cost;
			}
		}

		System.out.println(pointer >= 1 ? pointer : -1);
	}

}
