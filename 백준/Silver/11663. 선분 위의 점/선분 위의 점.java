import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Node {
	int x;
	int count;

	public Node(int x, int count) {
		this.x = x;
		this.count = count;
	}
}

public class Main {
	public static int n, m;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		arr = new int[n];

		
		s = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);

			sb.append(findUpperBound(end) - findLowerBound(start)).append('\n');
		}

		System.out.println(sb);
	}

	public static int findLowerBound(int target) {
		int l = 0;
		int r = n - 1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (arr[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return l;
	}

	public static int findUpperBound(int target) {
		int l = 0;
		int r = n - 1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (arr[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return r + 1;
	}
}
