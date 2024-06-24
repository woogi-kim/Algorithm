import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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
	public static int n;
	public static boolean isContinue = true;
	public static int time;
	public static int fishCount;
	public static int sharkX;
	public static int sharkSize = 2;
	public static int sharkEat;
	public static int sharkY;
	public static int[][] space;
	public static int[][] visited;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static int minX;
	public static int minY;
	public static int minDist;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		space = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int status = Integer.parseInt(s[j]);
				space[i][j] = status;
				if (status > 0 && status < 9) {
					fishCount++;
				} else if (status == 9) {
					sharkX = i;
					sharkY = j;
				}
			}
		}
		while (true) {
			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
			minDist = Integer.MAX_VALUE;
			visited = new int[n][n];

			bfs();

			if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				sharkEat++;
				space[minX][minY] = 0;
				sharkX = minX;
				sharkY = minY;
				time += visited[minX][minY];

				if (sharkEat == sharkSize) {
					sharkSize++;
					sharkEat = 0;
				}
			} else {
				break;
			}
		}

		System.out.println(time);
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sharkX, sharkY));

		space[sharkX][sharkY] = 0;

		while (!q.isEmpty()) {
			Node currentNode = q.poll();
			for (int i = 0; i < 4; i++) {
				int newX = currentNode.x + dx[i];
				int newY = currentNode.y + dy[i];
				if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
					if (visited[newX][newY] == 0) {
						if (space[newX][newY] <= sharkSize) {
							visited[newX][newY] = visited[currentNode.x][currentNode.y] + 1;

							if (space[newX][newY] < sharkSize && space[newX][newY] != 0) {
								if (minDist > visited[newX][newY]) {
									minDist = visited[newX][newY];
									minX = newX;
									minY = newY;
								} else if (minDist == visited[newX][newY]) {
									if (minX == newX) {
										if (minY > newY) {
											minX = newX;
											minY = newY;
										}
									} else if (minX > newX) {
										minX = newX;
										minY = newY;
										// }
									}
								}
							}
							q.add(new Node(newX, newY));
						}
					}
				}
			}
		}
	}
}
