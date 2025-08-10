import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static int n, m, x;
	public static ArrayList<Integer>[] ascList;
	public static ArrayList<Integer>[] descList;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		x = Integer.parseInt(s[2]);

		ascList = new ArrayList[n + 1];
		descList = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			ascList[i] = new ArrayList<>();
			descList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");

			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			descList[b].add(a);
			ascList[a].add(b);
		}

		int winnerCount = bfs(descList, x);
		int loserCount = bfs(ascList, x);

		System.out.println(winnerCount + " " + (n - loserCount + 1));

	}

	public static int bfs(ArrayList<Integer>[] adjList, int start) {
		visited = new boolean[n + 1];

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

				q.add(next);
				visited[next] = true;
				count++;
			}
		}

		return count;
	}

}
