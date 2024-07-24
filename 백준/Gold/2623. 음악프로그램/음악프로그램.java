import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static int n;
	public static int m;

	public static List<Set<Integer>> graph = new ArrayList<>();
	public static Queue<Integer> result = new LinkedList<>();
	public static int[] indegree;

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		for (int i = 0; i <= n; i++) {
			graph.add(new HashSet<>());
		}
		indegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");
			int singerCount = Integer.parseInt(s[0]);
			int[] singers = new int[singerCount];

			for (int j = 0; j < singerCount; j++) {
				singers[j] = Integer.parseInt(s[j + 1]);
			}

			for (int j = 0; j < singerCount - 1; j++) {
				for (int k = j + 1; k < singerCount; k++) {
					if(!graph.get(singers[j]).contains(singers[k])) {
						graph.get(singers[j]).add(singers[k]);
						indegree[singers[k]]++;
					}
				}
			}
		}

		topology();

		if (result.size() == n) {
			while (!result.isEmpty()) {
				sb.append(result.poll()).append('\n');
			}

			System.out.println(sb);
		} else {
			System.out.println(0);
		}

	}

	public static void topology() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				if (graph.get(i).size() == 0) {
					result.add(i);
				} else {
					q.add(i);
					result.add(i);
				}
			}
		}
		
		while (!q.isEmpty()) {
			Integer current = q.poll();
			for (int next : graph.get(current)) {
				indegree[next]--;
				if (indegree[next] == 0) {
					result.add(next);
					q.add(next);
				}
			}
		}
	}
}

