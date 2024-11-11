import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static int n;
	public static int[][] sands;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {-1, 0, 1, 0};

	public static double[][] leftSandScatter = {
		{0, 0, 0.02, 0, 0},
		{0, 0.1, 0.07, 0.01, 0},
		// -1은 a, -2는 이동할 칸(y), -3은 현재 위치(x)
		{0.05, -1, 0, 0, 0},
		{0, 0.1, 0.07, 0.01, 0},
		{0, 0, 0.02, 0, 0},
	};

	// 왼, 아, 오, 위
	public static double[][][] sandScatters;

	public static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		sands = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				sands[i][j] = Integer.parseInt(s[j]);
			}
		}

		// 회전해서 채우기
		sandScatters = new double[4][5][5];

		sandScatters[0] = leftSandScatter;
		for (int i = 1; i <= 3; i++) {
			sandScatters[i] = copyArray(leftSandScatter);
			for (int j = 0; j < i; j++) {
				sandScatters[i] = rotateArray(sandScatters[i]);
			}
		}

		// for (int i = 0; i < 4; i++) {
		// 	for (int j = 0; j < 5; j++) {
		// 		System.out.println(Arrays.toString(sandScatters[i][j]));
		// 	}
		// 	System.out.println();
		// }
		// 회전해서 모래
		int dist = 1;
		int dir = 0;
		int curX = n / 2;
		int curY = n / 2;
		int moveCount = 0;
		while (true) {
			for (int i = 0; i < dist; i++) {
				int nx = curX + dx[dir];
				int ny = curY + dy[dir];

				if (nx == 0 && ny == -1) {
					System.out.println(ans);
					return;
				}


				scatter(curX, curY, nx, ny, dir);
				// System.out.println("--------");
				// System.out.println("nx = " + nx);
				// System.out.println("ny = " + ny);
				// for (int k = 0; k < n; k++) {
				// 	System.out.println(Arrays.toString(sands[k]));
				// }
				curX = nx;
				curY = ny;
			}

			moveCount++;
			dir = (dir + 1) % 4;
			if (moveCount == 2) {
				moveCount = 0;
				dist++;
			}
		}

	}

	private static void scatter(int curX, int curY, int nx, int ny, int dir) {
		double[][] scatter = sandScatters[dir];

		int remainSand = sands[nx][ny];

		// System.out.println("remainSand1 = " + remainSand);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (scatter[i][j] > 0) {
					// System.out.println("i = " + i + " " + "j = " + j);
					int offsetX = i - 2;
					int offsetY = j - 2;

					int targetX = nx + offsetX;
					int targetY = ny + offsetY;

					// System.out.println("targetX = " + targetX + " " + "targetY = " + targetY);
					if (!inRange(targetX, targetY)) {
						ans += (int)(sands[nx][ny] * scatter[i][j]);
						// System.out.println("not in range");
						// System.out.println(
						// 	"Math.round(sands[nx][ny] * scatter[i][j]) = " + (int)(sands[nx][ny] * scatter[i][j]));
					} else {
						sands[targetX][targetY] += (int)(sands[nx][ny] * scatter[i][j]);
						// System.out.println("in range");
						// System.out.println(
						// 	"Math.round(sands[nx][ny] * scatter[i][j]) = " + (int)(sands[nx][ny] * scatter[i][j]));
					}

					remainSand -= (int)(sands[nx][ny] * scatter[i][j]);
				}
			}
		}

		int alphaX = nx + dx[dir];
		int alphaY = ny + dy[dir];
		// System.out.println("alphaX = " + alphaX + " " + "alphaY = " + alphaY);
		// System.out.println("remainSand2 = " + remainSand);
		if (!inRange(alphaX, alphaY)) {
			ans += remainSand;
		} else {
			sands[alphaX][alphaY] += remainSand;
		}

		sands[nx][ny] = 0;
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static double[][] rotateArray(double[][] arr) {
		double[][] result = new double[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				result[5 - 1 - j][i] = arr[i][j];
			}
		}

		return result;
	}

	public static double[][] copyArray(double[][] arr) {
		double[][] result = new double[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				result[i][j] = arr[i][j];
			}
		}

		return result;
	}
}