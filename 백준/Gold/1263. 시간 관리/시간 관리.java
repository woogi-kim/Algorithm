import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] s= bf.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}

		Arrays.sort(arr, (o1, o2) -> {
			return o2[1] - o1[1];
		});

		int endTime = arr[0][1] - arr[0][0];
		for (int i = 1; i < n; i++) {
			if (arr[i][1] < endTime) {
				endTime = arr[i][1];
			}

			endTime -= arr[i][0];
		}

		System.out.println(endTime > 0 ? endTime : -1);
	}
}
