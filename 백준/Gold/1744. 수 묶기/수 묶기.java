import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static int n;
	public static List<Integer> negatives = new ArrayList<>();
	public static List<Integer> positives = new ArrayList<>();
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(bf.readLine());
			if (tmp > 0) {
				positives.add(tmp);
			} else {
				negatives.add(tmp);
			}
		}

		Collections.sort(positives);
		Collections.sort(negatives);

		for (int i = positives.size() - 1; i >= 0; i -= 2) {
			if (i == 0) {
				ans += positives.get(i);
				break;
			}

			ans += Math.max((positives.get(i) * positives.get(i - 1)), positives.get(i) + positives.get(i - 1));
		}

		for (int i = 0; i < negatives.size(); i += 2) {
			if (i == negatives.size() - 1) {
				ans += negatives.get(i);
				break;
			}

			ans += Math.max((negatives.get(i) * negatives.get(i + 1)), negatives.get(i) + negatives.get(i + 1));
		}

		System.out.println(ans);
	}
}