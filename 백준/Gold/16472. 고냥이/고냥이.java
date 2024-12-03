import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static int ans;

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		String s = bf.readLine();

		arr = new int[26];

		int start = 0;
		int end= 0;

		int count = 1;
		arr[s.charAt(0) - 'a']++;

		while (end < s.length() - 1) {
			end++;

			if (arr[s.charAt(end) - 'a'] == 0) {
				count++;
				arr[s.charAt(end) - 'a']++;

				while (true) {
					if (count <= n) {
						break;
					}

					arr[s.charAt(start) - 'a']--;
					int tmp = arr[s.charAt(start) - 'a'];
					start++;

					if (tmp == 0) {
						count--;
					}
				}
			} else {
				arr[s.charAt(end) - 'a']++;
			}

			ans = Math.max(ans, end - start + 1);
		}

		System.out.println(ans);

	}
}