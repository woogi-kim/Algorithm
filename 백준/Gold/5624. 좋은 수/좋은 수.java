import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
	public static int n;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		arr = new int[n];

		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		Set<Integer> set = new HashSet<>();
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (set.contains(arr[i] - arr[j])) {
					ans++;
					break;
				}
			}

			for (int j = 0; j <= i; j++) {
				set.add(arr[i] + arr[j]);
			}
		}

		System.out.println(ans);
	}
}