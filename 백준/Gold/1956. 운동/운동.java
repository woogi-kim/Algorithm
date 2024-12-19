import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main {
	public static int[][] adjMatrix;
	public static int v,e;
	public static int[] parents;
	public static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		v = Integer.parseInt(s[0]);
		e = Integer.parseInt(s[1]);

		adjMatrix = new int[v + 1][v + 1];
		for (int i = 1; i <= v; i++) {
			Arrays.fill(adjMatrix[i], 100000000);
		}

		for (int i = 0; i < e; i++) {
			s = bf.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);

			adjMatrix[a][b] = c;
		}

		for (int k = 1; k <= v; k++) {
			for (int i = 1; i <= v; i++) {
				for (int j = 1; j <= v; j++) {
					adjMatrix[i][j] = Math.min(adjMatrix[i][j] , adjMatrix[i][k] + adjMatrix[k][j]);
				}
			}
		}

		int ans = 100000000;
		for (int i = 1; i <= v; i++) {
			if (adjMatrix[i][i] != 100000000) {
				ans = Math.min(ans, adjMatrix[i][i]);
			}
		}

		System.out.println(ans == 100000000 ? -1 : ans);
	}
}