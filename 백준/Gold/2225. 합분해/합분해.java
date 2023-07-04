import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dp;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[101][];

        try {
            String str = bufferedReader.readLine();
            String[] s = str.split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            dp = new int[k + 1][n + 1];
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = 1;
                }
            }
            for (int i = 1; i <= k; i++) {
                dp[i][1] = i;
            }
            for (int i = 2; i <= k; i++) {
                for (int j = 2; j <= n; j++) {
                    for (int l = 1; l <= j; l++) {
                        dp[i][j] += dp[i - 1][l];
                        dp[i][j] %= 1000000000;
                    }
                }
            }
            System.out.println(dp[k][n]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
