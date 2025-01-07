import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n, m;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			s = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");

			int a = Integer.parseInt(s[0]) - 1;
			int b = Integer.parseInt(s[1]) - 1;
			int c = Integer.parseInt(s[2]);

			if (c >= arr[a][b]) {
				sb.append("Enjoy other party").append('\n');
			} else {
				sb.append("Stay here").append('\n');
			}

		}

		System.out.println(sb);
	}
}
