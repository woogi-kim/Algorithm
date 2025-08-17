import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int d, n, m;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		d = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		m = Integer.parseInt(s[2]);

		arr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		arr[n] = d;

		Arrays.sort(arr);

		System.out.println(binarySearch());
	}

	public static int binarySearch() {
		int l = 1;
		int r = d + 1;

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
		int curNum = 0;
		int removedCount = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] - curNum >= distance) {
				curNum = arr[i];
			} else {
				removedCount++;
			}
		}

		return m >= removedCount;
	}
}