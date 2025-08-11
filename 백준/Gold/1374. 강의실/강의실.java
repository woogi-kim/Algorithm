import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Lecture {
	int start;
	int end;

	public Lecture(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	public static int n;

	public static int[][] input;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		input = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			input[i][0] = Integer.parseInt(s[0]);
			input[i][1] = Integer.parseInt(s[1]);
			input[i][2] = Integer.parseInt(s[2]);
		}

		Arrays.sort(input, (a, b) -> {
			if (a[1] == b[1]) {
				return a[2] - b[2];
			} else {
				return a[1] - b[1];
			}
		});

		PriorityQueue<Lecture> pq = new PriorityQueue<>((a, b) -> {
			return a.end - b.end;
		});

		pq.add(new Lecture(input[0][1], input[0][2]));
		for (int i = 1; i < n; i++) {
			Lecture cur = pq.peek();

			// 안겹치면
			if (cur.end <= input[i][1]) {
				pq.poll();
				pq.add(new Lecture(input[i][1], input[i][2]));
			} else {
				pq.add(new Lecture(input[i][1], input[i][2]));
			}
		}

		System.out.println(pq.size());
	}

}
