import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Building {
	int num;
	int height;

	public Building(int num, int height) {
		this.num = num;
		this.height = height;
	}
}

public class Main {
	public static int n;
	public static int[] arr;

	public static int[] visible;
	public static int[] visibleCount;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		arr = new int[n + 1];
		visible = new int[n + 1];
		visibleCount = new int[n + 1];

		String[] s = bf.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(s[i - 1]);
		}

		Stack<Building> stack = new Stack<>();
		for (int i = 1; i <= n; i++) {
			Building cur = new Building(i, arr[i]);

			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && stack.peek().height <= cur.height) {
					stack.pop();
				}
			}

			visible[i] = stack.isEmpty() ? 0 : stack.peek().num;
			visibleCount[i] += stack.size();
			stack.add(cur);
		}

		// System.out.println(Arrays.toString(visible));
		// System.out.println(Arrays.toString(visibleCount));

		stack = new Stack<>();
		for (int i = n; i >= 1; i--) {
			Building cur = new Building(i, arr[i]);

			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && stack.peek().height <= cur.height) {
					stack.pop();
				}
			}

			// visible[i] = stack.isEmpty() ? 0 : stack.peek().num;
			// 더 가깝다면 변경
			if (!stack.isEmpty()) {
				if (visible[i] == 0 || (Math.abs(visible[i] - cur.num) > Math.abs(stack.peek().num - cur.num))) {
					visible[i] = stack.peek().num;
				}
			}

			visibleCount[i] += stack.size();
			stack.add(cur);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			sb.append(visibleCount[i]);
			if (visibleCount[i] != 0) {
				sb.append(' ').append(visible[i]);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

}