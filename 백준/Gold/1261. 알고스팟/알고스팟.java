import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int ans = Integer.MAX_VALUE;
    public static int n, m;
    public static char[][] input;
    public static int[][] minBreak;
    public static boolean[][] visited;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        m = Integer.parseInt(tmp[0]);
        n = Integer.parseInt(tmp[1]);
        input = new char[n][m];
        minBreak = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            input[i] = bf.readLine().toCharArray();
            Arrays.fill(minBreak[i], Integer.MAX_VALUE);
        }
        minBreak[0][0] = 0;
        bfs();
        System.out.println(minBreak[n - 1][m - 1]);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            Node current = q.remove();
            if (current.x == n - 1 && current.y == m - 1) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if (input[newX][newY] == '1') {
                        if (minBreak[current.x][current.y] + 1 < minBreak[newX][newY]) {
                            q.add(new Node(newX, newY));
                            minBreak[newX][newY] = minBreak[current.x][current.y] + 1;
                            visited[newX][newY] = true;
                        }
                    } else {
                        if (!visited[newX][newY]) {
                            q.add(new Node(newX, newY));
                            minBreak[newX][newY] = minBreak[current.x][current.y];
                            visited[newX][newY] = true;
                        } else {
                            if (minBreak[current.x][current.y] < minBreak[newX][newY]) {
                                q.add(new Node(newX, newY));
                                minBreak[newX][newY] = minBreak[current.x][current.y];
                            }
                        }

                    }
                }
            }
        }
    }
}
