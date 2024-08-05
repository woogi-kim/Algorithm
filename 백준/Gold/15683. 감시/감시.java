import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Camera {
	int type;
	int x;
	int y;

	Camera(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int n;
	public static int m;
	public static int ans = Integer.MAX_VALUE;
	public static int[][] arr;
	public static boolean[][] visited;
	public static List<Camera> cameraList;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		arr = new int[n][m];
		visited = new boolean[n][m];
		cameraList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			s = bf.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					cameraList.add(new Camera(arr[i][j], i, j));
				}
			}
		}

		search(0, visited);

		System.out.println(ans);
	}

	public static void search(int depth, boolean[][] visited) {
		if (depth == cameraList.size()) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && arr[i][j] == 0) {
						count++;
					}
				}
			}

			ans = Math.min(ans, count);
			return;
		}

		Camera currentCamera = cameraList.get(depth);

		switch (currentCamera.type) {
			case 1:
				for (int i = 0; i < 4; i++) {
					boolean[][] newVisited = copyBooleanArray(visited);
					if (i == 0) {
						searchToDown(newVisited, currentCamera.x, currentCamera.y);
					} else if (i == 1) {
						searchToUp(newVisited, currentCamera.x, currentCamera.y);
					} else if (i == 2) {
						searchToLeft(newVisited, currentCamera.x, currentCamera.y);
					} else {
						searchToRight(newVisited, currentCamera.x, currentCamera.y);
					}
					search(depth + 1, copyBooleanArray(newVisited));
				}
				break;
			case 2:
				for (int i = 0; i < 2; i++) {
					boolean[][] newVisited = copyBooleanArray(visited);
					if (i == 0) {
						searchToUp(newVisited, currentCamera.x, currentCamera.y);
						searchToDown(newVisited, currentCamera.x, currentCamera.y);
					} else {
						searchToLeft(newVisited, currentCamera.x, currentCamera.y);
						searchToRight(newVisited, currentCamera.x, currentCamera.y);
					}
					search(depth + 1, copyBooleanArray(newVisited));
				}
				break;
			case 3:
				for (int i = 0; i < 4; i++) {
					boolean[][] newVisited = copyBooleanArray(visited);
					if (i == 0) {
						searchToUp(newVisited, currentCamera.x, currentCamera.y);
						searchToRight(newVisited, currentCamera.x, currentCamera.y);
					} else if (i == 1) {
						searchToRight(newVisited, currentCamera.x, currentCamera.y);
						searchToDown(newVisited, currentCamera.x, currentCamera.y);
					} else if (i == 2) {
						searchToDown(newVisited, currentCamera.x, currentCamera.y);
						searchToLeft(newVisited, currentCamera.x, currentCamera.y);
					} else {
						searchToUp(newVisited, currentCamera.x, currentCamera.y);
						searchToLeft(newVisited, currentCamera.x, currentCamera.y);
					}
					search(depth + 1, copyBooleanArray(newVisited));
				}
				break;
			case 4:
				for (int i = 0; i < 4; i++) {
					boolean[][] newVisited = copyBooleanArray(visited);

					if (i == 0) {
						searchToUp(newVisited, currentCamera.x, currentCamera.y);
						searchToRight(newVisited, currentCamera.x, currentCamera.y);
						searchToLeft(newVisited, currentCamera.x, currentCamera.y);
					} else if (i == 1) {
						searchToUp(newVisited, currentCamera.x, currentCamera.y);
						searchToRight(newVisited, currentCamera.x, currentCamera.y);
						searchToDown(newVisited, currentCamera.x, currentCamera.y);
					} else if (i == 2) {
						searchToRight(newVisited, currentCamera.x, currentCamera.y);
						searchToDown(newVisited, currentCamera.x, currentCamera.y);
						searchToLeft(newVisited, currentCamera.x, currentCamera.y);
					} else {
						searchToUp(newVisited, currentCamera.x, currentCamera.y);
						searchToLeft(newVisited, currentCamera.x, currentCamera.y);
						searchToDown(newVisited, currentCamera.x, currentCamera.y);
					}
					search(depth + 1, copyBooleanArray(newVisited));
				}
				break;
			case 5:
				boolean[][] newVisited = copyBooleanArray(visited);

				searchToUp(newVisited, currentCamera.x, currentCamera.y);
				searchToLeft(newVisited, currentCamera.x, currentCamera.y);
				searchToDown(newVisited, currentCamera.x, currentCamera.y);
				searchToRight(newVisited, currentCamera.x, currentCamera.y);

				search(depth + 1, copyBooleanArray(newVisited));
				break;
		}

	}

	public static void searchToDown(boolean[][] visited, int x, int y) {
		for (int i = x + 1; i < n; i++) {
			if (arr[i][y] == 6) {
				break;
			}
			visited[i][y] = true;
		}
	}

	public static void searchToUp(boolean[][] visited, int x, int y) {
		for (int i = x - 1; i >= 0; i--) {
			if (arr[i][y] == 6) {
				break;
			}
			visited[i][y] = true;
		}
	}

	public static void searchToLeft(boolean[][] visited, int x, int y) {
		for (int i = y - 1; i >= 0; i--) {
			if (arr[x][i] == 6) {
				break;
			}
			visited[x][i] = true;
		}
	}

	public static void searchToRight(boolean[][] visited, int x, int y) {
		for (int i = y + 1; i < m; i++) {
			if (arr[x][i] == 6) {
				break;
			}
			visited[x][i] = true;
		}
	}

	public static boolean[][] copyBooleanArray(boolean[][] original) {
		boolean[][] copy = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = original[i][j];
			}
		}
		return copy;
	}

}

