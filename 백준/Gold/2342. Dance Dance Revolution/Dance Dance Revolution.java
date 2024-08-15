import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[] input;
	public static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		int n = s.length - 1;
		input = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(s[i - 1]);
		}

		dp = new int[5][5][n + 1];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Arrays.fill(dp[i][j], 500000);
			}
		}

		dp[0][0][0] = 0;

		for (int i = 1; i <= n; i++) {
			int op = input[i];
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					dp[op][k][i] = Math.min(dp[op][k][i], dp[j][k][i - 1] + getCost(j, op));
					dp[j][op][i] = Math.min(dp[j][op][i], dp[j][k][i - 1] + getCost(k, op));
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ans = Math.min(ans, dp[i][j][n]);
			}
		}
		System.out.println(ans);
	}

	public static int getCost(int start, int end) {
		if (start == end) {
			return 1;
		} else if (start == 0) {
			return 2;
		} else if (Math.abs(start - end) % 2 == 1) {
			return 3;
		} else if (Math.abs(start - end) % 2 == 0) {
			return 4;
		}
		return -1;
	}

}
