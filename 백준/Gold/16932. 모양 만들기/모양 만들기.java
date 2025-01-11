import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int n, m;
	public static int[][] arr;
	public static int[][] arr2;
	public static List<Integer> shape = new ArrayList<>();
	public static boolean[][] visited;

	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		arr = new int[n][m];
		arr2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			s = bf.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}

		shape.add(0);

		visited = new boolean[n][m];
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					shape.add(0);
					bfs(i, j, num);
					num++;
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					int count = 1;
					HashSet<Integer> set = new HashSet<>();
					for (int k = 0; k < 4; k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];

						if (ni < 0 || ni >= n ||nj < 0 || nj >= m) {
							continue;
						}

						if (arr2[ni][nj] != 0) {
							set.add(arr2[ni][nj]);
						}
					}

					for (int k : set) {
						count += shape.get(k);
					}

					ans = Math.max(count, ans);
				}
			}
		}

		System.out.println(ans);
	}

	private static void bfs(int x, int y, int shapeNum) {
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(x, y));
		visited[x][y] = true;
		shape.set(shapeNum, shape.get(shapeNum) + 1);
		arr2[x][y] = shapeNum;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}

				if (visited[nx][ny]) {
					continue;
				}

				if (arr[nx][ny] != 1) {
					continue;
				}

				visited[nx][ny] = true;
				shape.set(shapeNum, shape.get(shapeNum) + 1);
				q.add(new Node(nx, ny));
				arr2[nx][ny] = shapeNum;
			}
		}
	}

}
