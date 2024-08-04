import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static int n;
	public static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		list = new ArrayList<>();

		list.add(0);
		
		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int current = Integer.parseInt(s[i]);

			if (current > list.get(list.size() - 1)) {
				list.add(current);
				continue;
			}

			int left = 0;
			int right = list.size() - 1;

			while (left < right) {
				int mid = (left + right) / 2;
				if (list.get(mid) >= current) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			list.set(right, current);
		}

		System.out.println(list.size() - 1);
	}
}

