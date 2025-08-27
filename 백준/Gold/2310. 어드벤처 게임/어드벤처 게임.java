import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// n이 1000이라 n^3 까지 가능하긴 함.
// 하지만... 기믹이 있다.
// 누적 코스트가 아니라 레프리콘을 만났을 때 금액이 '갱신'되버린다는 것
// 즉, 그래프로 표현할 수 있긴 하지만 최단거리 문제라고 보긴 어렵다.

// [노드][금액]을 기반으로 한 메모이제이션을 토대로, dfs를 굴리는게 가장 합리적인듯?
public class Main {
	public static int[] cost;
	public static ArrayList<Integer>[] adjList;
	public static char[] type;
	public static boolean[][] memoization;
	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			n = Integer.parseInt(bf.readLine());
			if (n == 0) {
				break;
			}

			cost = new int[n + 1];
			adjList = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				adjList[i] = new ArrayList<>();
			}
			memoization = new boolean[n + 1][501];
			type = new char[n + 1];

			for (int i = 0; i < n; i++) {
				String[] s = bf.readLine().split(" ");

				type[i + 1] = s[0].charAt(0);
				cost[i + 1] = Integer.parseInt(s[1]);

				for (int j = 2; j < s.length - 1; j++) {
					adjList[i + 1].add(Integer.parseInt(s[j]));
				}
			}

			dfs(1, 0);

			boolean ans = false;
			for (int i = 0; i <= 500; i++) {
				if (memoization[n][i]) {
					ans = true;
				}
			}

			sb.append(ans ? "Yes" : "No").append('\n');
		}

		System.out.println(sb);

	}

	public static void dfs(int node, int curCost) {
		if (memoization[node][curCost]) {
			return;
		}

		memoization[node][curCost] = true;

		for (int next : adjList[node]) {
			if (type[next] == 'E') {
				dfs(next, curCost);
			}
			if (type[next] == 'L') {
				dfs(next, Math.max(cost[next], curCost));
			}
			if (type[next] == 'T') {
				if (curCost - cost[next] >= 0) {
					dfs(next, curCost - cost[next]);
				}
			}
		}
	}
}