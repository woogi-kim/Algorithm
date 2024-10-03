import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static int[] arr;
	public static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		arr = new int[n];
		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		if (n == 2) {
			System.out.println(0);
			return;
		}

		int first = 0;
		int second = n - 1;
		while (first <= second) {
			int min = Math.min(arr[first], arr[second]);
			ans = Math.max((second - first - 1) * min, ans);

			if (arr[first] < arr[second]) {
				first++;
			} else {
				second--;
			}
		}
		System.out.println(ans);
	}
}