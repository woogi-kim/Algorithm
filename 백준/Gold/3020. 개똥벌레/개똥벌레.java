import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static int n, h;
	public static int[] up;
	public static int[] down;

	public static int destroyWall;
	public static int destroyCount;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		h = Integer.parseInt(s[1]);

		up = new int[n / 2];
		down = new int[n / 2];

		for (int i = 0; i < n / 2; i++) {
			down[i] = Integer.parseInt(bf.readLine());
			up[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(up);
		Arrays.sort(down);

		destroyWall = n;
		for (int i = 1; i <= h; i++) {
			int count = search(up, h - i + 1) + search(down, i);

			if (destroyWall == count) {
				destroyCount++;
				continue;
			}
			if (destroyWall > count) {
				destroyCount = 1;
				destroyWall = count;
			}
		}

		System.out.println(destroyWall + " " + destroyCount);
	}

	public static int search(int[] arr, int targetH) {
		int l = 0;
		int r = arr.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (arr[mid] < targetH) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return (n / 2) - l;
	}
}