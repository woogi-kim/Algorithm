import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Main {
	public static int n;
	public static int m;
	public static int[] indegree;
	public static ArrayList<Integer>[] adjList;

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		adjList = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		indegree = new int[n + 1];
		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			adjList[a].add(b);
			indegree[b]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				pq.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int cur = pq.poll();

			sb.append(cur).append(' ');

			for (int next : adjList[cur]) {
				indegree[next]--;
				if (indegree[next] == 0) {
					pq.add(next);
				}
			}

		}

		System.out.println(sb);
	}

}