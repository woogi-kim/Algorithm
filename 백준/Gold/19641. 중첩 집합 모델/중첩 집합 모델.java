import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static int n, root;
	public static ArrayList<Integer>[] edges;

	public static int[][] sequence;

	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		edges = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");

			int node = Integer.parseInt(s[0]);
			for (int j = 1; j < s.length - 1; j++) {
				edges[node].add(Integer.parseInt(s[j]));
			}
		}

		for (int i = 1; i <= n ; i++) {
			Collections.sort(edges[i]);
		}

		root = Integer.parseInt(bf.readLine());

		sequence = new int[n + 1][2];

		dfs(root);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(i)
				.append(' ').append(sequence[i][0])
				.append(' ').append(sequence[i][1])
				.append('\n');
		}

		System.out.println(sb);
	}

	private static void dfs(int node) {
		count++;
		sequence[node][0] = count;
		for (int next : edges[node]) {
			if (sequence[next][0] > 0) continue;
			
			dfs(next);
		}

		// int right = dfs()
		count++;
		sequence[node][1] = count;

	}

}