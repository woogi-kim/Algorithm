import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static int m;

	public static boolean[][] dp;
	public static int[] numbers;

	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		String[] s = bf.readLine().split(" ");
		numbers = new int[n + 1];
		for (int i = 0; i < n; i++) {
			numbers[i + 1] = Integer.parseInt(s[i]);
		}

		solve();

		m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);

			sb.append(dp[start][end] ? 1 : 0).append('\n');
		}
		System.out.println(sb.toString());
	}

	public static void solve() {
		dp = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;
		}

		for (int i = 1; i <= n - 1; i++) {
			if (numbers[i] == numbers[i + 1]) {
				dp[i][i + 1] = true;
			}
		}

		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				if (numbers[j] == numbers[j + i] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}
		}
	}

}
