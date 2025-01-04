import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static int n, b, w;
	public static char[] chars;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		b = Integer.parseInt(s[1]);
		w = Integer.parseInt(s[2]);

		chars = bf.readLine().toCharArray();

		int start = 0, end = -1;

		int bCount = 0;
		int wCount = 0;

		int ans = 0;
		while (end < n - 1) {
			end++;
			if (chars[end] == 'W') {
				wCount++;
			} else {
				bCount++;
				while (bCount > b) {
					if (chars[start] == 'W') {
						wCount--;
					} else {
						bCount--;
					}

					start++;
				}
			}

			if (bCount <= b && wCount >= w) {
				ans = Math.max(ans, end - start + 1);
			}
		}

		System.out.println(ans);
	}
}
