import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int ans = Integer.MAX_VALUE;
    public static int[][] arr;
    public static boolean[] visited;
    public static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        res = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtraking(i, i, 0, 0);
            visited[i] = false;
        }
        System.out.println(ans);
    }

    public static void backtraking(int start, int now, int depth, int sum) {
        if (depth == n - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                ans = Math.min(sum, ans);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[now][i] > 0) {
                visited[i] = true;
                backtraking(start, i, depth + 1, sum + arr[now][i]);
                visited[i] = false;
            }
        }
    }
}

