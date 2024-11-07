import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int[][] fishes = new int[4][4];
		int[] fishDirections = new int[17];

		for (int i = 0; i < 4; i++) {
			String[] s = bf.readLine().split(" ");
			for (int j = 0; j < 8; j += 2) {
				int fishNum = Integer.parseInt(s[j]);
				int fishDirection = Integer.parseInt(s[j + 1]) - 1;
				fishes[i][j / 2] = fishNum;
				fishDirections[fishNum] = fishDirection;
			}
		}

		backtracking(0, 0, copyArray(fishes), copyArray(fishDirections), 0);

		System.out.println(ans);
	}

	public static void backtracking(int sharkX, int sharkY, int[][] fishes, int[] fishDirection,
		int sum) {
		int sharkDirection = fishDirection[fishes[sharkX][sharkY]];
		sum += fishes[sharkX][sharkY];

		fishes[sharkX][sharkY] = 0;

		for (int i = 1; i <= 16; i++) {
			searchFish(sharkX, sharkY, fishes, fishDirection, i);
		}

		for (int i = 1; i <= 3; i++) {
			int nx = sharkX + dx[sharkDirection] * i;
			int ny = sharkY + dy[sharkDirection] * i;

			if (canSharkMove(nx, ny, fishes)) {
				// for (int m = 0; m < 4; m++) {
				// 	System.out.println(Arrays.toString(fishes[m]));
				// }
				// System.out.println("-----");
				backtracking(nx, ny, copyArray(fishes), copyArray(fishDirection), sum);
			}
		}

		ans = Math.max(ans, sum);
	}

	private static void searchFish(int sharkX, int sharkY, int[][] fishes, int[] fishDirection, int i) {
		for (int j = 0; j < 4; j++) {
			for (int k = 0; k < 4; k++) {
				if (fishes[j][k] == i) {
					int currentDirection = fishDirection[i];

					for (int l = 0; l < 8; l++) {
						int nx = j + dx[(l + currentDirection) % 8];
						int ny = k + dy[(l + currentDirection) % 8];


						if (canFishMove(nx, ny, sharkX, sharkY)) {
							fishDirection[i] = (l + currentDirection) % 8;
							moveFish(i, j, k, nx, ny, fishes);
							return;
						}
					}
				}
			}
		}
	}

	private static void moveFish(int fishNum, int x, int y, int nx, int ny, int[][] fishes) {
		if (fishes[nx][ny] == 0) {
			fishes[nx][ny] = fishNum;
			fishes[x][y] = 0;
		} else {
			int tmp = fishes[nx][ny];
			fishes[nx][ny] = fishes[x][y];
			fishes[x][y] = tmp;
		}
	}

	public static boolean canFishMove(int targetX, int targetY, int sharkX, int sharkY) {
		return inRange(targetX, targetY) && !(sharkX == targetX && sharkY == targetY);
	}

	public static boolean canSharkMove(int targetX, int targetY, int[][] fishes) {
		return inRange(targetX, targetY) && fishes[targetX][targetY] > 0;
	}

	public static boolean inRange(int x, int y) {
		return x >= 0 && x < 4 && y >= 0 && y < 4;
	}

	public static int[][] copyArray(int[][] arr) {
		int[][] result = new int[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				result[i][j] = arr[i][j];
			}
		}

		return result;
	}

	public static int[] copyArray(int[] arr) {
		int[] result = new int[17];

		for (int i = 0; i < 17; i++) {
			result[i] = arr[i];
		}

		return result;
	}
}