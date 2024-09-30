import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static int n;
	public static int[] digits;
	public static Set<String> set = new HashSet<>();
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		sb = new StringBuilder();
		
		while (n > 0) {
			String s = bf.readLine();

			digits = new int[26];
			for (int i = 0; i < s.length(); i++) {
				digits[s.charAt(i) - 'a']++;
			}

			set = new HashSet<>();
			backtracking(0, s.length(), "");
			n--;
		}
		System.out.print(sb.substring(0, sb.length()));

	}

	private static void backtracking(int depth, int end, String current) {
		if (depth == end) {
			sb.append(current).append('\n');
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (digits[i] == 0) {
				continue;
			}
			String tmp = current + (char) ('a' + i);

			digits[i]--;
			backtracking(depth + 1, end, tmp);
			digits[i]++;
		}
	}
}