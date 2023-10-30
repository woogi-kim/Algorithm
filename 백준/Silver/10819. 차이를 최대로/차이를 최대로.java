import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int ans = Integer.MIN_VALUE;
    public static int[] arr;
    public static boolean[] visited;
    public static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        res = new int[n];
        visited = new boolean[n];

        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        backtraking(0);
        System.out.println(ans);
    }

    public static void backtraking(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(res[i] - res[i + 1]);
            }
            ans = Math.max(ans, sum);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[depth] = arr[i];
                backtraking(depth + 1);
                visited[i] = false;
            }
        }
    }
}

