import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Word {
	int idx;
	String s;

	public Word(int idx, String s) {
		this.idx = idx;
		this.s = s;
	}
}

public class Main {
	public static Word[] words;
	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		words = new Word[n];
		for (int i = 0; i < n; i++) {
			words[i] = new Word(i, bf.readLine());
		}

		Arrays.sort(words, (a, b) -> a.s.compareTo(b.s));
		int maxLen = 0;

		// for (Word w : words) {
		// 	System.out.println(w.s);
		// }
		ArrayList<Word> candidates = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			int curLen = getDuplicateLength(words[i].s, words[i + 1].s);

			if (curLen >= maxLen) {
				if (curLen > maxLen) {
					candidates.clear();
				}
				maxLen = curLen;

				candidates.add(words[i]);
				candidates.add(words[i + 1]);
				//
				// System.out.println("curLen = " + curLen);
				// System.out.println(words[i].s);
				// System.out.println(words[i + 1].s);
			}
		}
		if (maxLen == 0) {
			System.out.println(words[0].s);
			System.out.println(words[1].s);
			return;
		}

		Collections.sort(candidates, (a, b) -> a.idx - b.idx);

		// System.out.println("candidate");
		// for (Word w : candidates) {
		// 	System.out.println(w.s);
		// }
		// System.out.println("---");

		Word first = candidates.get(0);
		System.out.println(first.s);
		for (int i = 1; i < candidates.size(); i++) {
			if (getDuplicateLength(first.s, candidates.get(i).s) == maxLen) {
				System.out.println(candidates.get(i).s);
				break;
			}
		}
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