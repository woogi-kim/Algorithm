import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static long[][] arr;
	public static long[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		arr = new long[n][n];
		dp = new long[n][n][3];

		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		dp[0][1][0] = 1;
		dp[0][2][0] = ((arr[0][2] == 1) ? 0 : 1);

		if (arr[1][2] == 0 && arr[1][1] == 0 && arr[0][2] == 0) {
			dp[1][2][2] = 1;
		}

		long ans = 0;
		for (int i = 0; i < 3; i++) {
			ans += solve(n - 1, n - 1, i);
		}

		System.out.println(ans);
	}

	public static long solve(int x, int y, int direction) {
		// 바운드 에러
		if (!inRange(x, y) || arr[x][y] == 1) {
			return 0;
		}

		// 이미 계산한 값
		if (dp[x][y][direction] != -1) {
			return dp[x][y][direction];
		}

		dp[x][y][direction] = 0;
		if (direction == 0) {
			dp[x][y][direction] += (solve(x, y - 1, 0) + solve(x, y - 1, 2));
		} else if (direction == 1) {
			dp[x][y][direction] += (solve(x - 1, y, 1) + solve(x - 1, y, 2));
		} else {
			if (inRange(x - 1, y) && inRange(x, y - 1)) {
				if (arr[x - 1][y] == 0 && arr[x][y - 1] == 0) {
					dp[x][y][direction] += (solve(x - 1, y - 1, 0) + solve(x - 1, y - 1, 1) + solve(x - 1, y - 1, 2));
				}
			}
		}

		return dp[x][y][direction];
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}
