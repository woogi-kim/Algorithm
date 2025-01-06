import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n;
	public static int[] arr;
	public static int[] sum;
	public static int[][] dp;

	public static int capacity;

	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		sum = new int[n + 1];
		dp = new int[4][n + 1];

		arr = new int[n];
		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		capacity = Integer.parseInt(bf.readLine());

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + arr[i - 1];
		}

		for (int i = 1; i <= 3; i++) {
			for (int j = i * capacity; j <= n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - capacity] + sum[j] - sum[j - capacity]);
			}
		}

		System.out.println(dp[3][n]);
	}

}
