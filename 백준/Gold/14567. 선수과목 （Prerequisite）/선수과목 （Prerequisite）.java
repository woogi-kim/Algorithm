
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int m;
    public static int[] dp;
    public static boolean[][] isPre;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        dp = new int[n + 1];
        isPre = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            isPre[a][b] = true;
        }

        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                if (isPre[j][i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = (max == Integer.MIN_VALUE) ? 1 : max + 1;
        }

        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(' ');
        }
        
        System.out.println(sb.toString());
    }

}



