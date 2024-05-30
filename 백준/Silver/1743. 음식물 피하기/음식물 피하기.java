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
    public static int m;
    public static int k;
    public static boolean[][] garbage;
    public static boolean[][] isVisited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        garbage = new boolean[n + 1][m + 1];
        isVisited = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            garbage[x][y] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (garbage[i][j] && !isVisited[i][j]) {
                    int adjGarbage = bfs(i, j);
                    ans = Math.max(ans, adjGarbage);
                }
            }
        }
        System.out.println(ans);
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        isVisited[x][y] = true;
        int result = 1;

        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if ((newX <= n && newX >= 1 && newY <= m && newY >= 1)) {
                    if (garbage[newX][newY] && !isVisited[newX][newY]) {
                        q.add(new Node(newX, newY));
                        isVisited[newX][newY] = true;
                        result++;
                    }
                }
            }
        }

        return result;
    }
}