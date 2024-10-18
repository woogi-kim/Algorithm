import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Planet {
	int idx;
	int x;
	int y;
	int z;

	public Planet(int idx, int x, int y, int z) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

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
	public static Planet[] planets;
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		planets = new Planet[n];
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int z = Integer.parseInt(s[2]);
			planets[i] = new Planet(i, x, y, z);
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		Arrays.sort(planets, (o1, o2) -> o1.x - o2.x);
		for (int i = 0; i < n - 1; i++) {
			pq.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].x - planets[i + 1].x)));
		}
		Arrays.sort(planets, (o1, o2) -> o1.y - o2.y);
		for (int i = 0; i < n - 1; i++) {
			pq.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].y - planets[i + 1].y)));
		}
		Arrays.sort(planets, (o1, o2) -> o1.z - o2.z);
		for (int i = 0; i < n - 1; i++) {
			pq.add(new Edge(planets[i].idx, planets[i + 1].idx, Math.abs(planets[i].z - planets[i + 1].z)));
		}

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		long ans = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (find(cur.start) != find(cur.end)) {
				union(cur.start, cur.end);
				ans += cur.cost;
			}
		}

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

		if (x <= y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}
}