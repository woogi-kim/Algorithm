import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Homework {
	int day;
	int score;

	public Homework(int day, int score) {
		this.day = day;
		this.score = score;
	}
}

public class Main {
	public static int n;
	public static Homework[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		arr = new Homework[n];
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			arr[i] = new Homework(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1.day == o2.day) {
				return o2.score - o1.score;
			} else {
				return o1.day - o2.day;
			}
		});

		PriorityQueue<Homework> pq = new PriorityQueue<>((o1, o2) -> o1.score - o2.score);

		pq.add(new Homework(arr[0].day, arr[0].score));

		for (int i = 1; i < n; i++) {
			if (pq.size() == arr[i].day) {
				Homework poll = pq.poll();
				if (poll.score <= arr[i].score) {
					pq.add(new Homework(arr[i].day, arr[i].score));
				} else {
					pq.add(new Homework(poll.day, poll.score));
				}
			} else if (pq.size() < arr[i].day) {
				pq.add(new Homework(arr[i].day, arr[i].score));
			}
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll().score;
		}
		System.out.println(ans);
	}
}