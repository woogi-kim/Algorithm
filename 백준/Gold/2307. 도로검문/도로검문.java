import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int to;
	int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
public class Main {
	public static int n, m;

	public static int[] dist;
	public static ArrayList<int[]>[] graph;

	public static int shortestTime;

	public static int[] path;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bf.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		path = new int[n + 1];

		for (int i = 0; i < m; i++) {
			input = bf.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);

			graph[start].add(new int[] {end, weight});
			graph[end].add(new int[] {start, weight});
		}

		shortestTime = getMaxTime();

		int maxTime = -1;
		for (int i = n; i > 1; i = path[i]) {
			maxTime = Math.max(maxTime, getMaxTime(i, path[i]));
		}

		if (maxTime == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(maxTime - shortestTime);
		}
	}

	private static int getMaxTime(int n1, int n2) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[1] = 0;
		pq.add(new int[] {1, 0});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (dist[cur[0]] < cur[1]) continue;

			for (int[] next : graph[cur[0]]) {
				if (dist[cur[0]] + next[1] > dist[next[0]]) continue;
				if (cur[0] == n1 && next[0] == n2) continue;
				if (cur[0] == n2 && next[0] == n1) continue;

				dist[next[0]] = dist[cur[0]] + next[1];
				pq.add(new int[] {next[0], dist[next[0]]});
			}
		}

		return dist[n];
	}

	private static int getMaxTime() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		dist[1] = 0;
		pq.add(new int[] {1, 0});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if (dist[cur[0]] < cur[1]) continue;
			for (int[] next : graph[cur[0]]) {
				if (dist[cur[0]] + next[1] > dist[next[0]]) {
					continue;
				}

				dist[next[0]] = dist[cur[0]] + next[1];
				path[next[0]] = cur[0];
				pq.add(new int[] {next[0], dist[next[0]]});
 			}
		}

		return dist[n];
	}
}