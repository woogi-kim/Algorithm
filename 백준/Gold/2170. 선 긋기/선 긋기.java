import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static int n;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");

			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		});

		int min = arr[0][0];
		int max = arr[0][1];

		int ans = 0;
		ans += (max - min);

		for (int i = 1; i < n; i++) {
			if (arr[i][0] >= min && arr[i][1] <= max) {
				continue;
			} else if (arr[i][0] <= max && arr[i][1] > max) {
				ans += (arr[i][1] - max);
			} else {
				ans += (arr[i][1] - arr[i][0]);
			}

			min = arr[i][0];
			max = arr[i][1];
		}

		System.out.println(ans);
	}
}