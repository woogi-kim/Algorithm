import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
// 길이를 기준으로 정렬을 해야되나...
// 그래도 테케가 50개라 결국 50억 연산...

// Set에 싹다 넣고 존재하는 지 확인해서 품

// 구민은 그냥 사전순으로 정렬 후 인접한 것만 검색

public class Main {
	public static int n;
	public static int[] arr;
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		arr = new int[n];
		dp = new int[n];

		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		int length = 0;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > dp[length]) {
				length++;
				dp[length] = arr[i];
			} else {
				idx = binarySearch(0,length, arr[i]);
				dp[idx] = arr[i];
			}
		}

		System.out.println(n - length);
	}

	public static int binarySearch(int l, int r, int key) {
		int mid = 0;
		while (l < r) {
			mid = (l + r) / 2;

			if (dp[mid] < key) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return r;
	}
}