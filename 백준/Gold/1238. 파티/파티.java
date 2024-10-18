import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int idx;
	int cost;

	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Main {
	public static int n, m, x;
	public static ArrayList<Node>[] graph;
	public static int[] partyToHome;
	public static int[] homeToParty;

	public static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// n = Integer.parseInt(bf.readLine());
		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		x = Integer.parseInt(s[2]);

		graph = new ArrayList[m + 1];
		for (int i = 0; i <= m; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");

			int start = Integer.parseInt(s[0]);
			int dest = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);

			graph[start].add(new Node(dest, cost));
		}

		partyToHome = new int[n + 1];
		homeToParty = new int[n + 1];

		doDijkstra();

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, partyToHome[i] + homeToParty[i]);
		}

		System.out.println(ans);
	}

	private static void doDijkstra() {
		for (int i = 1; i <= n; i++) {
			dijkstra(i);
			homeToParty[i] = dist[x];
			if (i == x) {
				for (int j = 1; j <= n; j++) {
					partyToHome[j] = dist[j];
				}
			}
		}
	}

	private static void dijkstra(int start) {
		dist = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;
		visited[start] = true;

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (Node next : graph[cur.idx]) {


				if (dist[next.idx] < dist[cur.idx] + next.cost) {
					continue;
				}

				dist[next.idx] = dist[cur.idx] + next.cost;
				pq.add(new Node(next.idx, next.cost));
				visited[next.idx] = true;
			}
		}

	}

}