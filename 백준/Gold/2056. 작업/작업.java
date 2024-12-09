import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static int n;
	public static int[] dp;
	public static int[] times;
	public static ArrayList<Integer>[] graph;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		dp = new int[n + 1];
		times = new int[n + 1];

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			String[] s = bf.readLine().split(" ");
			times[i] = Integer.parseInt(s[0]);

			int inward = Integer.parseInt(s[1]);
			if (inward == 0) dp[i] = times[i];

			for (int j = 0; j < inward; j++) {
				int start = Integer.parseInt(s[j + 2]);
				graph[start].add(i);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int next : graph[i]) {
				dp[next] = Math.max(dp[next], dp[i] + times[next]);
			}
		}

		for (int i = 1; i <= n; i++) {
			ans = Math.max(dp[i], ans);
		}

		System.out.println(ans);
	}
}