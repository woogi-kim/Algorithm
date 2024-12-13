import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n, d, k, c;
	public static int[] counts;
	public static int[] belt;
	public static int sushiTypeCount;
	public static int ans;

 	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		d = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);
		c = Integer.parseInt(s[3]) - 1;

		counts = new int[d];
		belt = new int[n];
		for (int i = 0; i < n; i++) {
			int type = Integer.parseInt(bf.readLine()) - 1;
			belt[i] = type;
		}

		for (int i = 0; i < k; i++) {
			if (counts[belt[i]] == 0) {
				sushiTypeCount++;
			}
			counts[belt[i]]++;
		}

		if (counts[c] == 0) {
			ans = sushiTypeCount + 1;
		}

		for (int i = 0; i < n; i++) {
			counts[belt[i]]--;
			if (counts[belt[i]] == 0) {
				sushiTypeCount--;
			}

			if (counts[belt[(i + k) % n]] == 0) {
				sushiTypeCount++;
			}
			counts[belt[(i + k) % n]]++;

			ans = Math.max(ans, sushiTypeCount);
			if (counts[c] == 0) {
				ans = Math.max(ans, sushiTypeCount + 1);
			}
		}

		System.out.println(ans);
	}

}