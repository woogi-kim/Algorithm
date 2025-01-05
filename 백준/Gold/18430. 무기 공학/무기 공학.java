import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[][] dx = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	public static int[][] dy = {{-1, 0}, {-1, 0}, {0, 1}, {0, 1}};

	public static int n, m;
	public static int[][] strength;
	public static boolean[][] visited;

	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		strength = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			s = bf.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				strength[i][j] = Integer.parseInt(s[j]);
			}
		}

		dfs(0, 0);

		System.out.println(ans);
	}

	public static void dfs(int idx, int sum) {
		if (idx == n * m) {
			ans = Math.max(ans, sum);
			return;
		}

		int cx = idx / m;
		int cy = idx % m;

		if (!visited[cx][cy]) {
			for (int i = 0; i < 4; i++) {
				int nx1 = cx + dx[i][0];
				int nx2 = cx + dx[i][1];
				int ny1 = cy + dy[i][0];
				int ny2 = cy + dy[i][1];

				if (isPossible(nx1, nx2, ny1, ny2)) {
					visited[cx][cy] = true;
					visited[nx1][ny1] = true;
					visited[nx2][ny2] = true;
					dfs(idx + 1, sum + (strength[cx][cy] * 2) + strength[nx1][ny1] + strength[nx2][ny2]);
					visited[cx][cy] = false;
					visited[nx1][ny1] = false;
					visited[nx2][ny2] = false;
				}
			}
		}

		dfs(idx + 1, sum);

	}

	private static boolean isPossible(int nx1, int nx2, int ny1, int ny2) {
		if (nx1 >= n || nx1 < 0) {
			return false;
		}
		if (nx2 >= n || nx2 < 0) {
			return false;
		}
		if (ny1 >= m || ny1 < 0) {
			return false;
		}
		if (ny2 >= m || ny2 < 0) {
			return false;
		}
		if (visited[nx1][ny1]) {
			return false;
		}
		if (visited[nx2][ny2]) {
			return false;
		}

		return true;
	}
}
