import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static int n;
	public static int k;
	public static int dest;

	public static List<List<Integer>> graph;
	public static Queue<Integer> q;
	public static int[] indegree;
	public static int[] cost;
	public static int[] result;

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t > 0) {
			String[] s = bf.readLine().split(" ");

			n = Integer.parseInt(s[0]);
			k = Integer.parseInt(s[1]);

			graph = new ArrayList<>();
			q = new LinkedList<>();
			indegree = new int[n + 1];
			cost = new int[n + 1];
			result = new int[n + 1];

			s = bf.readLine().split(" ");

			for (int i = 0; i < n; i++) {
				cost[i + 1] = Integer.parseInt(s[i]);
			}

			for (int i = 0; i < n + 1; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < k; i++) {
				s = bf.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);

				graph.get(start).add(end);
				indegree[end]++;
			}

			dest = Integer.parseInt(bf.readLine());

			topologySort();

			sb.append(result[dest]).append('\n');
			t--;
		}
		System.out.println(sb);
	}

	private static void topologySort() {
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		for (int i = 1; i <= n; i++) {
			result[i] = cost[i];
		}

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int next : graph.get(current)) {
				result[next] = Math.max(result[next], result[current] + cost[next]);
				indegree[next]--;
				if (indegree[next] == 0) {
					q.add(next);
				}
			}
		}
	}
}

