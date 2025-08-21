import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static String[] words;
	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = bf.readLine();
		}

		int max = 0;
		String first = "";
		String second = "";

		for (int i = 0; i < n; i++) {
			if (words[i].length() < max) {
				continue;
			}
			for (int j = i + 1; j < n; j++) {
				if (words[j].length() < max) {
					continue;
				}
				
				int duplicateLength = getDuplicateLength(words[i], words[j]);

				if (duplicateLength > max) {
					max = duplicateLength;
					first = words[i];
					second = words[j];
				}
			}
		}

		System.out.println(first);
		System.out.println(second);

	}

	public static int getDuplicateLength(String a, String b) {
		int len = Math.min(a.length(), b.length());

		int count = 0;
		for (int i = 0; i < len; i++) {
			if (a.charAt(i) == b.charAt(i)) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}
}