
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] weights;
    public static int[] values;
    public static int[][] dp;
    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        weights = new int[n + 1];
        values = new int[n + 1];
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            s = bf.readLine().split(" ");
            weights[i] = Integer.parseInt(s[0]);
            values[i] = Integer.parseInt(s[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weights[i] >=0){
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i][j]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }

}


