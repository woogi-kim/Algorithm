import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] pos = new int[N + 1][2];
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] delta = new int[][] {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		long[][] DP = new long[N + 1][5];
		int si = pos[0][0];
		int sj = pos[0][1];
		for (int i = 0; i < 5; i++) {
			DP[1][i] = abs(si - (pos[1][0] + delta[i][0])) + abs(sj - (pos[1][1] + delta[i][1]));
		}

		for (int k = 2; k < N + 1; k++) {
			for (int a = 0; a < 5; a++) {
				int i = pos[k][0] + delta[a][0];
				int j = pos[k][1] + delta[a][1];
				// long dis = Long.MAX_VALUE;
				long dis = 200000L * k;
				if (isRange(i, j) == true) {
					for (int b = 0; b < 5; b++) {
						int prei = pos[k - 1][0] + delta[b][0];
						int prej = pos[k - 1][1] + delta[b][1];
						dis = Math.min(dis, abs(i - prei) + abs(j - prej) + DP[k - 1][b]);
					}
				}
				DP[k][a] = dis;
			}
		}
		long ans = DP[N][0];
		for (int i = 1; i < 5; i++) {
			ans = Math.min(ans, DP[N][i]);
		}
		System.out.println(ans);
	}

	public static int abs(int i) {
		if (i < 0) {
			return -i;
		}
		return i;
	}

	public static boolean isRange(int i, int j) {
		if (0 <= i && i < 100000 && 0 <= j && j < 100000) {
			return true;
		}
		return false;
	}
}