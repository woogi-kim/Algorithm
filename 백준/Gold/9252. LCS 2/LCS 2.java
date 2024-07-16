import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[][] arr;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		char[] str1 = bf.readLine().toCharArray();
		char[] str2 = bf.readLine().toCharArray();

		int n = str1.length;
		int m = str2.length;

		arr = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				arr[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					if (arr[i - 1][j] > arr[i][j - 1]) {
						arr[i][j] = arr[i - 1][j];
					} else {
						arr[i][j] = arr[i][j - 1];
					}
				}
			}
		}

		int max = 0;
		int maxIdx = 0;

		for (int i = 1; i <= n; i++) {
			if (max < arr[i][m]) {
				max = arr[i][m];
				maxIdx = i;
			}
		}

		int i = maxIdx;
		int j = m;
		while (i >= 1 && j >= 1) {
			if (str1[i - 1] == str2[j - 1]) {
				sb.append(str1[i - 1]);
				i--;
				j--;
			} else {
				if (arr[i - 1][j] > arr[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}

		System.out.println(max);
		if (max != 0) {
			System.out.println(sb.reverse());
		}
	}
}
