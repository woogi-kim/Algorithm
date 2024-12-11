import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


public class Main {
	public static int n, m, l;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		l = Integer.parseInt(s[2]);

		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(l);

		if (n != 0) {
			s = bf.readLine().split(" ");

			for (int i = 0; i < s.length; i++) {
				list.add(Integer.parseInt(s[i]));
			}
		}

		Collections.sort(list);

		int lo = 0;
		int hi = l;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;

			int count = 0;
			for (int i = 1; i < list.size(); i++) {
				count += ((list.get(i) - list.get(i - 1) - 1) / mid);
			}

			if (count <= m) {
				hi = mid;
			} else  {
				lo = mid;
			}

		}

		System.out.println(hi);
	}

}