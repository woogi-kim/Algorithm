import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static int totalLength;
	public static int m;
	public static int cutCount;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		totalLength = n * m;

		int currentLength = 0;
		while (currentLength < totalLength) {
			currentLength += n;
			if (currentLength % m == 0) {
				continue;
			}
			cutCount++;
		}
		System.out.println(cutCount);
	}

}
