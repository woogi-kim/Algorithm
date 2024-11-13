import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pos {
	int x;
	int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int n, m;
	public static int[][] waters;

	public static ArrayList<Pos> clouds;
	public static boolean[][] disappeared;

	public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bf.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		waters = new int[n][n];
		for (int i = 0; i < n; i++) {
			input = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				waters[i][j] = Integer.parseInt(input[j]);
			}
		}

		clouds = new ArrayList<>();
		clouds.add(new Pos(n - 1, 0));
		clouds.add(new Pos(n - 1, 1));
		clouds.add(new Pos(n - 2, 0));
		clouds.add(new Pos(n - 2, 1));

		while (m-- > 0) {
			input = bf.readLine().split(" ");
			int d = Integer.parseInt(input[0]) - 1;
			int s = Integer.parseInt(input[1]);

			moveClouds(d, s);
			rain();

			copyWater();
			makeCloud();
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += waters[i][j];
			}
		}

		System.out.println(ans);
	}

	private static void makeCloud() {
		clouds = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (waters[i][j] >= 2 && !disappeared[i][j]) {
					clouds.add(new Pos(i, j));
					waters[i][j] -= 2;
				}
			}
		}
	}

	private static void copyWater() {
		int[][] increaseAmount = new int[n][n];

		for (Pos pos : clouds) {
			int amount = 0;
			for (int i = 1; i < 8; i += 2) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if ((nx >= 0 && nx < n && ny >= 0 && ny < n) && waters[nx][ny] > 0) {
					amount++;
				}
			}
			increaseAmount[pos.x][pos.y] = amount;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (increaseAmount[i][j] > 0) {
					waters[i][j] += increaseAmount[i][j];
				}
			}
		}
	}

	private static void rain() {
		disappeared = new boolean[n][n];

		for (Pos pos : Main.clouds) {
			waters[pos.x][pos.y]++;
			disappeared[pos.x][pos.y] = true;
		}
	}

	private static void moveClouds(int d, int s) {
		for (Pos pos : Main.clouds) {
			int nx = pos.x + (dx[d] * (s % n));
			int ny = pos.y + (dy[d] * (s % n));

			if (nx >= 0)
				nx %= n;
			if (nx < 0)
				nx = n - Math.abs(nx);

			if (ny >= 0)
				ny %= n;
			if (ny < 0)
				ny = n - Math.abs(ny);

			pos.x = nx;
			pos.y = ny;
		}
	}
}