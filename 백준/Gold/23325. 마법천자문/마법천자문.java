import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static int[][] dp;
	public static String input;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		input = bf.readLine();

		int n = input.length();
		dp = new int[n][2];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}

		dp[0][1] = convert(input.substring(0, 1));
		if (n == 1) {
			System.out.println(dp[0][1]);
			return;
		}

		dp[1][0] = dp[0][1];
		if (convert(input.substring(0, 2)) == 11) {
			dp[1][1] = 11;
		}

		for (int i = 2; i < n; i++) {
			if (dp[i - 1][1] != Integer.MIN_VALUE) {
				dp[i][0] = dp[i - 1][1];
			}

			if (dp[i - 1][0] != Integer.MIN_VALUE) {
				dp[i][1] =
					input.charAt(i - 1) == '+' ? Math.max(dp[i - 1][0] + convert(input.substring(i, i + 1)), dp[i][1]) :
						Math.max(dp[i - 1][0] - convert(input.substring(i, i + 1)), dp[i][1]);
			}

			if (dp[i - 2][0] != Integer.MIN_VALUE) {
				if (input.substring(i - 1, i + 1).equals("+-")) {
					dp[i][1] =
						input.charAt(i - 2) == '+' ? Math.max(dp[i - 2][0] + 11, dp[i][1]) :
							Math.max(dp[i - 2][0] - 11, dp[i][1]);
				}
			}
		}

		// for (int i = 0; i < n; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }
		System.out.println(dp[n - 1][1]);
	}

	public static int convert(String s) {
		if (s.equals("+")) {
			return 10;
		} else if (s.equals("-")) {
			return 1;
		} else if (s.equals("+-")) {
			return 11;
		} else {
			return -1;
		}
	}

}