
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[] cost;
    public static int[] dp;
    public static boolean[][] isPre;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        cost = new int[n + 1];
        dp = new int[n + 1];
        isPre = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] s = bf.readLine().split(" ");
            cost[i] = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            for (int j = 0; j < m; j++) {
                isPre[i][Integer.parseInt(s[2 + j])] = true;
            }
        }


        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (isPre[i][j]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max == 0 ? cost[i] : max + cost[i];
        }

        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}



