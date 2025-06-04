import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
	public static int n;
	public static String[] words;
	public static int[] weight;

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		weight = new int[26];
		words = new String[n];

		for (int i = 0; i < n; i++) {
			words[i] = bf.readLine();
		}

		for (String s : words) {
			for (int i = s.length() - 1; i >= 0; i--) {
				weight[s.charAt(i) - 'A'] += ((int)Math.pow(10, s.length() - 1 - i));
			}
		}

		int ans = 0;
		int lastNum = 9;
		Arrays.sort(weight);
		for (int i = 25; i >= 0; i--) {
			if (weight[i] > 0) {
				ans += weight[i] * lastNum;
				lastNum--;
			}
		}

		System.out.println(ans);
	}

}

