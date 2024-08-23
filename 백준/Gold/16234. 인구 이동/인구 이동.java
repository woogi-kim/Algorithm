import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;

	}
}

public class Main {
	public static int n;
	public static int[][] population;
	public static boolean[][] visited;
	public static int l, r;
	public static int ans;

	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		l = Integer.parseInt(s[1]);
		r = Integer.parseInt(s[2]);

		population = new int[n][n];
		for (int i = 0; i < n; i++) {
			s = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				population[i][j] = Integer.parseInt(s[j]);
			}
		}

		while (true) {
			visited = new boolean[n][n];
			List<Set<Node>> unions = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						unions.add(new HashSet<>());

						bfs(new Node(i, j), unions.get(unions.size() - 1));
					}
				}
			}

			if (unions.size() == n * n) {
				out.println(ans);
				exit(0);
			}
			for (Set<Node> set : unions) {
				int sum = 0;
				for (Node node : set) {
					sum += population[node.x][node.y];
				}

				int divisionResult = sum / set.size();
				for (Node node : set) {
					population[node.x][node.y] = divisionResult;
				}
			}

			ans++;
		}
	}

	public static void bfs(Node start, Set<Node> set) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		set.add(new Node(start.x, start.y));
		visited[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Node current = q.poll();
			for (int i = 0; i < 4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
					int diff = Math.abs(population[current.x][current.y] - population[newX][newY]);

					if (!visited[newX][newY]) {
						if (diff >= l && diff <= r) {
							visited[newX][newY] = true;
							q.add(new Node(newX, newY));
							set.add(new Node(newX, newY));
						}
					}
				}
			}
		}
	}

}
