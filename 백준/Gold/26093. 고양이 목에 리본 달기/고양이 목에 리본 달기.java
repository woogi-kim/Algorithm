import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static int n, k;

	public static int[][] dp;

	public static int[][] input;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);

		input = new int[n][k];
		for (int i = 0; i < n; i++) {
			s = bf.readLine().split(" ");
			for (int j = 0; j < k; j++) {
				input[i][j] = Integer.parseInt(s[j]);
			}
		}

		dp = new int[n][k];

		for (int i = 0; i < k; i++) {
			dp[0][i] = input[0][i];
		}

		int[] before = deepCopySort(dp[0]);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if (before[0] == dp[i - 1][j]) {
					dp[i][j] = before[1] + input[i][j];
				} else {
					dp[i][j] = before[0] + input[i][j];
				}
			}
			before = deepCopySort(dp[i]);
		}

		int ans = 0;

		for (int i = 0; i < k; i++) {
			ans = Math.max(dp[n - 1][i], ans);
		}

		System.out.println(ans);
	}

	public static int[] deepCopySort(int[] original) {
		int[] tmp = new int[original.length];

		for (int i = 0; i < original.length; i++) {
			tmp[i] = original[i];
		}

		Arrays.sort(tmp);

		int[] target = new int[tmp.length];
		for (int i = tmp.length - 1; i >= 0; i--) {
			target[i] = tmp[tmp.length - 1 - i];
		}

		return target;
	}
}
