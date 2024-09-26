import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int n;
	public static int c;

	public static int[] house;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);

		house = new int[n];
		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(house);

		int minDist = 1;
		int maxDist = house[n - 1] - house[0] + 1;

		while (minDist + 1 < maxDist) {
			int midDist = (minDist + maxDist) / 2;

			int lastHouse = house[0];
			int router = 1;

			for (int i = 1; i < n; i++) {
				int nextHouse = lastHouse + midDist;

				if (house[i] >= nextHouse) {
					lastHouse = house[i];
					router++;
				}
			}


			if (router >= c) {
				minDist = midDist;
			} else {
				maxDist = midDist;
			}
		}

		System.out.println(minDist);


	}



}
