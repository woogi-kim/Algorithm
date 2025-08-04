import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
	public static int n;

	public static double[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		dp = new double[n + 1];
		dp[1] = 1.0;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i - j >= 0) {
					dp[i] += (1.0 / 6.0) * (dp[i - j] + 1);
				} else {
					dp[i] += (1.0 / 6.0);
				}
			}
		}
		System.out.println(dp[n]);
	}
}