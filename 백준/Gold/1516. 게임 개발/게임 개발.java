import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 깡 위상정렬로 푼다.

public class Main {
	public static int n;
	public static int[] indegree;
	public static int[] times;
	public static int[] dp;
	public static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		indegree = new int[n + 1];
		times = new int[n + 1];
		dp = new int[n + 1];

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			String[] s = bf.readLine().split(" ");

			times[i] = Integer.parseInt(s[0]);
			for (int j = 1; j < s.length; j++) {
				int previous = Integer.parseInt(s[j]);

				if (previous == -1) {
					continue;
				}

				indegree[i]++;
				graph[previous].add(i);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				dp[i] = times[i];
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph[cur]) {
				indegree[next]--;
				dp[next] = Math.max(dp[next], dp[cur] + times[next]);

				if (indegree[next] == 0) {
					q.add(next);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(dp[i]).append('\n');
		}

		System.out.println(sb);
	}

}