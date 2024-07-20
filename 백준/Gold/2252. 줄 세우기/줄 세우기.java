import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static int n;
	public static int m;

	public static List<List<Integer>> graph;
	public static Queue<Integer> result = new LinkedList<>();
	public static Queue<Integer> q = new LinkedList<>();
	public static int[] indegree;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		graph = new ArrayList<>();
		indegree = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);

			graph.get(start).add(end);
			indegree[end]++;
		}

		topologySort();

		StringBuilder sb = new StringBuilder();

		while(!result.isEmpty()) {
			sb.append(result.poll()).append(' ');
		}

		System.out.println(sb);
	}

	private static void topologySort() {
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			Integer current = q.poll();
			result.add(current);

			for (int next : graph.get(current)) {
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
	}

}
