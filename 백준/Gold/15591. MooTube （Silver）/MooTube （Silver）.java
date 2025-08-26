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
import java.util.Stack;

class Node {
	int idx;
	int cost;

	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Main {
	public static int n, q;
	public static ArrayList<Node>[] adjList;
	public static int[] costs;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		q = Integer.parseInt(s[1]);

		costs = new int[n + 1];
		adjList = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			s = bf.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);

			adjList[a].add(new Node(b, cost));
			adjList[b].add(new Node(a, cost));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			s = bf.readLine().split(" ");
			int k = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);

			bfs(v);
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (j == v) {
					continue;
				}

				if (costs[j] >= k) {
					count++;
				}
			}

			sb.append(count).append('\n');
		}

		System.out.println(sb);

	}

	public static void bfs(int start) {
		costs = new int[n + 1];
		Arrays.fill(costs, -1);

		Queue<Integer> q = new LinkedList<>();

		costs[start] = Integer.MAX_VALUE;
		q.add(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (Node next : adjList[cur]) {
				if (costs[next.idx] != -1) {
					continue;
				}

				costs[next.idx] = Math.min(costs[cur], next.cost);
				q.add(next.idx);
			}
		}
	}
}