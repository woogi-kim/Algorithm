import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 전체 코스트를 낮추는 거니까 다익스트라는 안됨...
// MST 반복?
// pq써서 MST 하는건 알겠는데 어떻게 발전소랑 연결돼있는지 감지하지?

class Edge {
	int s;
	int e;
	int cost;

	public Edge(int s, int e, int cost) {
		this.s = s;
		this.e = e;
		this.cost = cost;
	}
}

public class Main {
	public static int n, m, k;
	public static int[] supplies;
	public static int[] parents;
	public static PriorityQueue<Edge> pq;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);

		parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		s = bf.readLine().split(" ");
		for (int i = 0; i < k; i++) {
			parents[Integer.parseInt(s[i])] = 0;
		}

		pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);
			pq.add(new Edge(start, end, cost));
		}

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			int a = find(cur.s);
			int b = find(cur.e);

			if (a != b) {
				union(a, b);
				ans += cur.cost;
			}
		}

		System.out.println(ans);
	}

	public static int find(int x) {
		if (parents[x] == x) {
			return x;
		}

		return parents[x] = find(parents[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
	}

}