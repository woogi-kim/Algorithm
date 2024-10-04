import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n, m, k;
	public static int[] money;
	public static int[] parents;
	public static int[] moneySum;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);

		money = new int[n + 1];
		parents = new int[n + 1];

		s = bf.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			money[i] = Integer.parseInt(s[i - 1]);
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			union(a, b);
		}

		moneySum = new int[n + 1];
		Arrays.fill(moneySum, Integer.MAX_VALUE);

		for (int i = 1; i <= n; i++) {
			parents[i] = find(i);
		}
		for (int i = 1; i <= n; i++) {
			moneySum[parents[i]] = Math.min(moneySum[parents[i]], money[i]);
		}

		long ans = 0;
		for (int i = 1; i <= n; i++) {
			if (moneySum[i] != Integer.MAX_VALUE) {
				ans += moneySum[i];
			}
		}

		System.out.println(ans > k ? "Oh no" : ans);
	}

	public static int find(int a) {
		if (a == parents[a]) {
			return a;
		} else {
			return parents[a] = find(parents[a]);
		}
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (a < b) {
				parents[b] = a;
			} else {
				parents[a] = b;
			}
		}
	}
}