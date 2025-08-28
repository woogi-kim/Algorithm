import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		int ans = 0;

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			// System.out.println("x = " + x + " , y = " + y);
			while (!stack.isEmpty() && y < stack.peek()) {
				int pop = stack.pop();
				// System.out.println("pop = " + pop);
				ans++;
			}

			if (y == 0 || (!stack.isEmpty() && y == stack.peek())) {
				// System.out.println("continue");
				continue;
			}

			stack.add(y);
		}
		if (!stack.isEmpty()) {
			ans += stack.size();
		}

		System.out.println(ans);
	}

}