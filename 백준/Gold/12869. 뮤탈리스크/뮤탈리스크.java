import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	public static int[][][] visited;
	public static int[] dx1 = {9, 3, 1};
	public static int[] dx2 = {1, 3, 9};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		arr = new int[3];

		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		bfs();

		System.out.println(ans);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		int[] firstArr = Arrays.copyOf(arr, 3);
		q.add(new Node(firstArr, 0));

		visited = new int[61][61][61];

		visited[arr[0]][arr[1]][arr[2]] = 0;

		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				Arrays.fill(visited[i][j], -1);
			}
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (isAllDied(cur.nums)) {
				ans = cur.count;
				break;
			}

			for (int i = 0; i < 3; i++) {
				int[] tmp = new int[3];
				for (int j = 0; j < 3; j++) {
					tmp[j] = cur.nums[j] - dx1[(j + i) % 3];
					tmp[j] = Math.max(tmp[j], 0);
				}

				if (visited[tmp[0]][tmp[1]][tmp[2]] != -1) {
					continue;
				}
				visited[tmp[0]][tmp[1]][tmp[2]] = cur.count + 1;
				q.add(new Node(tmp, cur.count + 1));
			}

			for (int i = 0; i < 3; i++) {
				int[] tmp = new int[3];
				for (int j = 0; j < 3; j++) {
					tmp[j] = cur.nums[j] - dx2[(j + i) % 3];
					tmp[j] = Math.max(tmp[j], 0);
				}

				if (visited[tmp[0]][tmp[1]][tmp[2]] != -1) {
					continue;
				}
				visited[tmp[0]][tmp[1]][tmp[2]] = cur.count + 1;
				q.add(new Node(tmp, cur.count + 1));
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
}