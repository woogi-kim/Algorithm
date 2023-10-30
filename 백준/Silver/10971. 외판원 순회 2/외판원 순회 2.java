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
        
        backtraking(0);
        System.out.println(ans);
    }

    public static void backtraking(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[res[i]][res[i + 1]] != 0) {
                    sum += arr[res[i]][res[i + 1]];
                } else {
                    return;
                }
            }
            if (arr[res[n - 1]][res[0]] != 0) {
                sum += arr[res[n - 1]][res[0]];
            } else {
                return;
            }
            ans = Math.min(ans, sum);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[depth] = i;
                backtraking(depth + 1);
                visited[i] = false;
            }
        }
    }
}

