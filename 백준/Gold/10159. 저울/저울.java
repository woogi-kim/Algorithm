import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static ArrayList<Integer>[] adjList1;
	public static ArrayList<Integer>[] adjList2;
	public static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());

		adjList1 = new ArrayList[n + 1];
		adjList2 = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adjList1[i] = new ArrayList<>();
			adjList2[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			String[] s = bf.readLine().split(" ");

			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			adjList1[a].add(b);
			adjList2[b].add(a);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(n - 1 - ((bfs(adjList1, i) + bfs(adjList2, i)))).append('\n');
		}

		System.out.println(sb);
	}

	public static int bfs(ArrayList<Integer>[] adjList, int start) {
		boolean[] visited = new boolean[n + 1];

		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		visited[start] = true;

		int count = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : adjList[cur]) {
				if (visited[next]) {
					continue;
				}

				visited[next] = true;
				q.add(next);
				count++;
			}
		}

		return count - 1;
	}
}