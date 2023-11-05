import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m, k;
    public static char[][] input;
    public static int[][][] mem;
    public static char[] target;
    public static int ans;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        input = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            for (int j = 0; j < m; j++) {
                input[i][j] = s.charAt(j);
            }
        }

        target = bf.readLine().toCharArray();
        mem = new int[n][m][target.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j] == target[0]) {
                    ans += dfs(i, j, 0);
                }
            }
        }

        System.out.println(ans);
    }

    public static int dfs(int x, int y, int depth) {
        if (mem[x][y][depth] != -1) {
            return mem[x][y][depth];
        }
        if (depth + 1 == target.length) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= k; j++) {
                int newX = x + dx[i] * j;
                int newY = y + dy[i] * j;
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if (input[newX][newY] == target[depth + 1]) {
                        count += dfs(newX, newY, depth + 1);
                    }
                }
            }
        }
        mem[x][y][depth] = count;
        return count;
    }
}
