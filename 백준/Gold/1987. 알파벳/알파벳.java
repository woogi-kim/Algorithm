import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String[][] inputBoard;
    public static boolean[][] visited;
    public static int r, c;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int ans = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        inputBoard = new String[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            inputBoard[i] = bf.readLine().split("");
        }

        visited[0][0] = true;

        dfs(0, 0, inputBoard[0][0]);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, String str) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c) {
                if (!str.contains(inputBoard[nextX][nextY])) {
                    dfs(nextX, nextY, str.concat(inputBoard[nextX][nextY]));
                }
            }
            ans = Math.max(ans, str.length());
        }
    }
}
