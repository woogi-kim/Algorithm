import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int w, h;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0)
                break;

            arr = new int[h + 1][w + 1];
            visit = new boolean[h + 1][w + 1];
            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                for (int j = 1; j <= w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            count = 0;
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (!visit[i][j] && arr[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');

        }
        System.out.println(sb);

    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((1 <= nx && nx <= h) && (1 <= ny && ny <= w)) {
                if (!visit[nx][ny] && arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }

    }
}
