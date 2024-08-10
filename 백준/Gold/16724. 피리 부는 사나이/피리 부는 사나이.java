import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static int n;
	public static int m;
	public static char[][] arr;
	public static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		arr = new char[n][m];
		parents = new int[n * m];

		for (int i = 0; i < n; i++) {
			String tmp = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = tmp.charAt(j);
				parents[i * m + j] = i * m + j;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int newX = i;
				int newY = j;
				switch (arr[i][j]) {
					case 'U':
						newX--;
						break;
					case 'D':
						newX++;
						break;
					case 'L':
						newY--;
						break;
					case 'R':
						newY++;
						break;
				}

				union(i * m + j, newX * m + newY);
			}
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				set.add(find(i * m + j));
			}
		}
		System.out.println(set.size());
	}

	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);

		if (aParent < bParent) {
			parents[bParent] = aParent;
		} else {
			parents[aParent] = bParent;
		}
	}

	public static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
}
