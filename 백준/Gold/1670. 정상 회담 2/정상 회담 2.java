import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static int n;
	public static long[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		numbers = new long[10001];

		numbers[0] = 1;
		numbers[2] = 1;
		numbers[4] = 2;

		for (int i = 6; i < 10000; i += 2) {
			for (int j = 0; j <= i - 2; j += 2) {
				numbers[i] += numbers[j] * numbers[i - j - 2];
				numbers[i] %= 987654321;
			}
		}

		System.out.println(numbers[n]);
	}
}