import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Node {
	int x;
	int count;

	public Node(int x, int count) {
		this.x = x;
		this.count = count;
	}
}

public class Main {
	public static int n, m;
	public static ArrayList<Integer>[] adjList;
	public static boolean[] visited;
	public static int start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		String[] s = bf.readLine().split(" ");

		start = Integer.parseInt(s[0]);
		end = Integer.parseInt(s[1]);

		adjList = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");

			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			adjList[a].add(b);
			adjList[b].add(a);
		}

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));

		int ans = -1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int next : adjList[cur.x]) {
				if (visited[next]) {
					continue;
				}

				if (next == end) {
					ans = cur.count + 1;
					break;
				}

				q.add(new Node(next, cur.count + 1));
				visited[next] = true;
			}
		}

		System.out.println(ans);
	}

}
