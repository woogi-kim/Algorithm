import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// abc
// 931
// 193
// 319
// 139
// 913
// 391

class Node {
	int[] nums;
	int count;

	public Node(int[] nums, int count) {
		this.nums = nums;
		this.count = count;
	}
}

public class Main {
	public static int n;
	public static int[] arr;
	public static int ans;
	public static int[] dx1 = {9, 3, 1};
	public static int[] dx2 = {1, 3, 9};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		arr = new int[n];

		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		bfs();

		System.out.println(ans);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		int[] firstArr = Arrays.copyOf(arr, arr.length);
		q.add(new Node(firstArr, 0));

		HashSet<String> set = new HashSet<>();
		set.add(getKey(firstArr));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (isAllDied(cur.nums)) {
				ans = cur.count;
				break;
			}

			for (int i = 0; i < 3; i++) {
				int[] tmp = new int[n];
				for (int j = 0; j < n; j++) {
					tmp[j] = cur.nums[j] - dx1[(j + i) % 3];
				}

				if (!set.contains(getKey(tmp))) {
					set.add(getKey(tmp));
					q.add(new Node(tmp, cur.count + 1));
				}
			}

			for (int i = 0; i < 3; i++) {
				int[] tmp = new int[n];
				for (int j = 0; j < n; j++) {
					tmp[j] = cur.nums[j] - dx2[(j + i) % 3];
				}

				if (!set.contains(getKey(tmp))) {
					set.add(getKey(tmp));
					q.add(new Node(tmp, cur.count + 1));
				}
			}
		}

	}

	private static boolean isAllDied(int[] nums) {
		for (int num : nums) {
			if (num > 0) {
				return false;
			}
		}

		return true;
	}

	public static String getKey(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int num : nums) {
			sb.append(num).append(',');
		}
		return sb.toString();
	}
}