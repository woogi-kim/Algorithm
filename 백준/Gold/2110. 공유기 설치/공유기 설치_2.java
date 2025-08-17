import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static int n, c;
	public static int[] arr;
	public static int maxRange;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);

		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			maxRange = Math.max(arr[i], maxRange);
		}

		Arrays.sort(arr);

		System.out.println(binarySearch());
	}

	public static int binarySearch() {
		int l = 1;
		int r = maxRange + 1;

		while (l + 1 < r) {
			int mid = (l + r) / 2;

			if (check(mid)) {
				l = mid;
			} else {
				r = mid;
			}
		}

		return l;
	}

	public static boolean check(int distance) {
		int count = 1;
		int curNum = arr[0];

		for (int i = 1; i < n; i++) {
			if (arr[i] - curNum >= distance) {
				curNum = arr[i];
				count++;
			}
		}

		return count >= c;
	}
}
