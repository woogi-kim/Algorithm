import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int x;
	int y;
	int cost;

	public Node(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}

public class Main {
	// public static ArrayList<Integer>[] graph;
	public static int n;
	public static int[] parents;
	public static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		parents = new int[n];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			for (int j = 0; j <= i; j++) {
				int cost = Integer.parseInt(s[j]);
				pq.add(new Node(i, j, cost));
			}
		}

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int cost = cur.cost;

			if (find(x) != find(y)) {
				union(x, y);
				ans += cost;
			}
		}

		System.out.println(ans);
	}

	public static int find(int x) {
		if (x == parents[x]) {
			return x;
		}

		return parents[x] = find(parents[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (y < x) {
			parents[x] = y;
		} else {
			parents[y] = x;
		}
	}

}