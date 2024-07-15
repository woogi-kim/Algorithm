import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static long[] features;

	public static int left;
	public static int right;

	public static int ml;
	public static int mr;
	public static long currentMin = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		features = new long[n];

		String[] s = bf.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			features[i] = Long.parseLong(s[i]);
		}

		left = 0;
		right = n - 1;

		while (left < right) {
			long sum = features[left] + features[right];
			if (currentMin > Math.abs(sum)) {
				currentMin = Math.abs(sum);
				ml = left;
				mr = right;
			}
			if (sum >= 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(features[ml] + " " + features[mr]);
	}
}
