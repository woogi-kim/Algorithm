import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n;
	public static int m;

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		arr = new int[n];

		s = bf.readLine().split(" ");

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
		}

		int lo = -1;
		int hi = 10000;

		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;

			int tmpMax = arr[0];
			int tmpMin = arr[0];
			int groupCount = 1;
			for (int i = 1; i < n; i++) {
				int current = arr[i];
				tmpMax = Math.max(current, tmpMax);
				tmpMin = Math.min(current, tmpMin);

				if ((tmpMax - tmpMin) > mid) {
					tmpMax = current;
					tmpMin = current;
					groupCount++;
				}
			}


			if (groupCount > m) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		System.out.println(hi);

	}
}