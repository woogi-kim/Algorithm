import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static int d, n, m;
	public static int[] rocks;
	public static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		d = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		m = Integer.parseInt(s[2]);

		rocks = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			rocks[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(rocks);

		long lo = 0;
		long hi = d;

		while (lo <= hi) {
			long mid = (lo + hi) / 2;

			int removeCount = 0;

			int startIdx = 0;
			for (int i = 1; i <= n; i++) {
				if (mid <= rocks[i] - rocks[startIdx]) {
					startIdx = i;
				} else {
					removeCount++;
				}
			}

			if (removeCount > m) {
				hi = mid - 1;
			} else {
				ans = (int)mid;
				lo = mid + 1;
			}
		}

		System.out.println(ans);
	}

}