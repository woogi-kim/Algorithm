import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int t;
	public static int[][] arr;
	public static int[] arrRow;
	public static int[] arrCol;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(bf.readLine());
		while (t > 0) {
			String[] s = bf.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);

			// arr = new int[n + 1][n + 1];
			// arrCount = new int[n + 1][n + 1];

			arrRow = new int[n + 1];
			arrCol = new int[n + 1];

			for (int i = 0; i < n; i++) {
				s = bf.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					int tmp = Integer.parseInt(s[j]);
					arrRow[i + 1] += tmp;
					arrCol[j + 1] += tmp;
				}
			}

			for (int i = 0; i < m; i++) {
				s = bf.readLine().split(" ");
				int r1 = Integer.parseInt(s[0]);
				int c1 = Integer.parseInt(s[1]);
				int r2 = Integer.parseInt(s[2]);
				int c2 = Integer.parseInt(s[3]);
				int v = Integer.parseInt(s[4]);

				for (int j = r1; j <= r2; j++) {
					arrRow[j] += (v * (c2 - c1 + 1));
				}

				for (int j = c1; j <= c2; j++) {
					arrCol[j] += (v * (r2 - r1 + 1));
				}
			}

			for (int i = 1; i <= n; i++) {
				sb.append(arrRow[i]).append(' ');
			}

			sb.append('\n');

			for (int i = 1; i <= n; i++) {
				sb.append(arrCol[i]).append(' ');
			}

			sb.append('\n');

			t--;
		}

		System.out.println(sb);

	}

}
