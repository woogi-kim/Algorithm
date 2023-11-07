import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int ans;
    public static boolean[][] visited = new boolean[2001][2001];
    public static boolean[][] isRectangle = new boolean[2001][2001];
    public static int x1, y1, x2, y2;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x1 = (Integer.parseInt(st.nextToken()) + 500) * 2;
            y1 = (Integer.parseInt(st.nextToken()) + 500) * 2;
            x2 = (Integer.parseInt(st.nextToken()) + 500) * 2;
            y2 = (Integer.parseInt(st.nextToken()) + 500) * 2;
            for (int j = x1; j <= x2; j++) {
                isRectangle[j][y1] = true;
                isRectangle[j][y2] = true;
            }
            for (int j = y1; j <= y2; j++) {
                isRectangle[x1][j] = true;
                isRectangle[x2][j] = true;
            }

        }

        for (int i = 0; i <= 2000; i++) {
            for (int j = 0; j <= 2000; j++) {
                if (!visited[i][j] && isRectangle[i][j]) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        if (isRectangle[1000][1000]) {
            ans--;
        }

        System.out.println(ans);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX <= 2000 && nextY >= 0 && nextY <= 2000) {
                if (!visited[nextX][nextY] && isRectangle[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }

        }
    }

}

