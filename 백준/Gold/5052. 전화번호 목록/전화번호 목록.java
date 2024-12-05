import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
// 길이를 기준으로 정렬을 해야되나...
// 그래도 테케가 50개라 결국 50억 연산...

public class Main {
	public static int n;
	public static String[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			n = Integer.parseInt(bf.readLine());
			numbers = new String[n];

			for (int i = 0; i < n; i++) {
				numbers[i] = bf.readLine();
			}

			Arrays.sort(numbers, (s1, s2) -> s2.length() - s1.length());

			HashSet<String> set = new HashSet<>();
			boolean isConsistent = true;

			for (int i = 0; i < n; i++) {
				if (set.contains(numbers[i])) {
					isConsistent = false;
					sb.append("NO").append('\n');
					break;
				}

				for (int j = 0; j <= numbers[i].length(); j++) {
					set.add(numbers[i].substring(0, j));
				}
			}

			if (isConsistent) {
				sb.append("YES").append('\n');
			}
		}
		System.out.println(sb);
	}
}