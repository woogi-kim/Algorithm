import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

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
	public static int n;
	public static int m;
	public static int[] parents;
	public static int maxCost = Integer.MIN_VALUE;
	public static long ans;
	public static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);

			pq.add(new Edge(start, end, cost));
		}

		while (!pq.isEmpty()) {
			Edge current = pq.poll();

			int startParent = find(current.start);
			int endParent = find(current.end);
			if (startParent != endParent) {
				union(startParent, endParent);
				ans += current.cost;
				maxCost = Math.max(maxCost, current.cost);
			}
		}

		System.out.println(ans - maxCost);
	}

	public static int find(int x) {
		if (x == parents[x]) {
			return x;
		}

		return parents[x] = find(parents[x]);
	}

	public static void union(int x, int y) {
		int xParent = find(x);
		int yParent = find(y);

		if (xParent < yParent) {
			parents[yParent] = xParent;
		} else {
			parents[xParent] = yParent;
		}
	}
}

