import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static String a, b;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		a = bf.readLine();
		b = bf.readLine();
		int n = a.length();
		int m = b.length();
		dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					if (dp[i - 1][j] > dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}

		int max = 0;
		int maxIdx = 0;

		for (int i = 1; i <= n; i++) {
			if (max < dp[i][m]) {
				max = dp[i][m];
				maxIdx = i;
			}
		}

		int i = maxIdx;
		int j = m;
		StringBuilder sb = new StringBuilder();
		while (i >= 1 && j >= 1) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				sb.append(a.charAt(i - 1));
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}

		System.out.println(max);
		if (max != 0) {
			System.out.println(sb.reverse());
		}
	}

}