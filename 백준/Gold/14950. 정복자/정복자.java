import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Edge {
	int start;
	int end;
	int cost;

	public Edge(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class Main {
	public static int n, m, t;
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		t = Integer.parseInt(s[2]);

		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
			return o1.cost - o2.cost;
		});
		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");

			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);

			pq.add(new Edge(start, end, cost));
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				ans += edge.cost;
			}
		}

		ans += (((n - 1) * (n - 2) / 2 ) * t);

		System.out.println(ans);
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}
}
