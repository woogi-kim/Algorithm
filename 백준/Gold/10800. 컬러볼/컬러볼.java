import java.io.*;
import java.util.Arrays;
import java.util.Stack;

class Ball {
	int idx;
	int color;
	int size;

	public Ball(int idx, int color, int size) {
		this.idx = idx;
		this.color = color;
		this.size = size;
	}
}

public class Main {
	public static int n;
	public static int[] colorSum;
	public static int[] result;
	public static Ball[] balls;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		colorSum = new int[200001];
		balls = new Ball[n];
		result = new int[n];
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			int color = Integer.parseInt(s[0]);
			int size = Integer.parseInt(s[1]);
			balls[i] = new Ball(i, color, size);
		}

		Arrays.sort(balls, (a, b) -> a.size - b.size);

		int totalSum = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			Ball cur = balls[i];

			while (balls[j].size < cur.size) {
				totalSum += balls[j].size;
				colorSum[balls[j].color] += balls[j].size;

				j++;
			}

			result[cur.idx] = totalSum - colorSum[cur.color];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append('\n');
		}

		System.out.println(sb);
	}
}