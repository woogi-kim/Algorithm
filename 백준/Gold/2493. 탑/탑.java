import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Tower {
	int height;
	int idx;

	public Tower(int height, int idx) {
		this.height = height;
		this.idx = idx;
	}
}

public class Main {
	public static int n;
	public static int[] heights;
	public static int[] receivedBy;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		receivedBy = new int[n + 1];
		heights = new int[n + 1];

		String[] s = bf.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			heights[i] = Integer.parseInt(s[i - 1]);
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = n; i >= 1; i--) {
			while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
				int top = stack.pop();
				receivedBy[top] = i;
			}

			stack.add(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(receivedBy[i]).append(' ');
		}

		System.out.println(sb);
	}

}