import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static String ans = "";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		backtracking(0, n, "");

		System.out.print(ans);
	}

	private static void backtracking(int depth, int end, String current) {
		if (depth == end) {
			if (ans.isEmpty()) {
				ans = current;
			} else {
				if (ans.compareTo(current) > 0) {
					ans = current;
				}
			}
			return;
		}

		for (int i = 1; i <= 3; i++) {
			String tmp = current + i;
			if (ans.isEmpty() || tmp.compareTo(ans.substring(0, tmp.length())) <= 0) {
				if (isGoodSequence(tmp)) {
					backtracking(depth + 1, end, tmp);
				}
			}

		}
	}

	private static boolean isGoodSequence(String s) {
		int n = s.length();
		int m = s.length() / 2;

		for (int i = m; i >= 1; i--) {
			String subSequence1 = s.substring(n - i, n);
			String subSequence2 = s.substring(n - 2 * i, n - i);
			if (subSequence1.equals(subSequence2)) {
				return false;
			}
		}
		return true;
	}

}