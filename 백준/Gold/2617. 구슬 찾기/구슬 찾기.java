import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static ArrayList<Integer>[] adjList1;
	public static ArrayList<Integer>[] adjList2;

	public static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		adjList1 = new ArrayList[n + 1];
		adjList2 = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			adjList1[i] = new ArrayList<>();
			adjList2[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			adjList1[start].add(end);
			adjList2[end].add(start);
		}

		Set<Integer> ans = new HashSet<>();

		for (int i = 1; i <= n; i++) {
			if (bfs(adjList1, i) >= (n + 1) / 2 || bfs(adjList2, i) >= (n + 1) / 2) {
				ans.add(i);
			}
		}
		// for (int i : ans) {
		// 	System.out.println(i);
		// }
		System.out.println(ans.size());
	}

	public static int bfs(ArrayList<Integer>[] adjList, int start) {
		int result = 0;

		boolean[] visited = new boolean[n + 1];

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : adjList[cur]) {
				if (visited[next]) {
					continue;
				}

				q.add(next);
				visited[next] = true;
				result++;
			}
		}

		return result;
	}

}