import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int num;
	int cost;

	public Node(int num, int cost) {
		this.num = num;
		this.cost = cost;
	}
}

public class Main {
	public static int n, m;
	public static ArrayList<Node>[] adjList;
	public static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		adjList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");

			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);

			adjList[start].add(new Node(end, cost));
			adjList[end].add(new Node(start, cost));
		}
		dist = new int[n + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

		pq.add(new Node(1, 0));
		dist[1] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.cost > dist[cur.num]) {
				continue;
			}

			for (Node next : adjList[cur.num]) {
				if (dist[next.num] > dist[cur.num] + next.cost) {
					dist[next.num] = dist[cur.num] + next.cost;
					pq.add(new Node(next.num, dist[next.num]));
				}
			}
		}

		System.out.println(dist[n]);
	}

}