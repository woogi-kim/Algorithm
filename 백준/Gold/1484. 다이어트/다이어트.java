import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static int g;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		g = Integer.parseInt(bf.readLine());

		int l = 1;
		int r = 1;
		ArrayList<Integer> ans = new ArrayList<>();

		while (true) {
			if (r * r - l * l < g && r <= g) {
				r++;
			} else if (r * r - l * l == g && r <= g) {
				ans.add(r);
				r++;
			} else if (r * r - l * l > g) {
				l++;
			} else {
				break;
			}
		}

		if (ans.isEmpty()) {
			System.out.println(-1);
			return;
		}

		for (int i : ans) {
			System.out.println(i);
		}

	}

}