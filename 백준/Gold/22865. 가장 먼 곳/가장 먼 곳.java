import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int to;
	long cost;

	public Node(int to, long cost) {
		this.to = to;
		this.cost = cost;
	}
}

public class Main {
	public static int n, m;
	public static long[][] dist;
	public static int[] friendsHomes;
	public static ArrayList<Node>[] graph;

	public static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		friendsHomes = new int[3];
		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < 3; i++) {
			friendsHomes[i] = Integer.parseInt(s[i]);
		}

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int d = Integer.parseInt(s[0]);
			int e = Integer.parseInt(s[1]);
			int l = Integer.parseInt(s[2]);
			graph[d].add(new Node(e, l));
			graph[e].add(new Node(d, l));
		}

		dist = new long[3][n + 1];
		for (int i = 0; i < 3; i++) {
			int start = friendsHomes[i];
			Arrays.fill(dist[i], Long.MAX_VALUE);

			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int)(o1.cost - o2.cost));
			pq.add(new Node(start, 0L));
			dist[i][start] = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (dist[i][cur.to] < cur.cost) {
					continue;
				}

				for (Node next : graph[cur.to]) {
					if (dist[i][cur.to] + next.cost < dist[i][next.to]) {
						dist[i][next.to] = dist[i][cur.to] + next.cost;
						pq.add(new Node(next.to, dist[i][cur.to] + next.cost));
					}
				}
			}
		}

		long maxVal = Long.MIN_VALUE;
		long maxIdx = 0;
		for (int i = 1; i <= n; i++) {
			if (maxVal < Math.min(dist[0][i], Math.min(dist[1][i], dist[2][i]))) {
				maxVal = Math.min(dist[0][i], Math.min(dist[1][i], dist[2][i]));
				maxIdx = i;
			}
		}

		System.out.println(maxIdx);
	}

}