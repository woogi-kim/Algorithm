import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] dp;
    public static int[] squareNum;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            dp = new int[n + 1];
            squareNum = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                squareNum[i] = -1;
            }

            for (int i = 2; i * i <= n; i++) {
                squareNum[i] = i * i;
            }

            dp[1] = 1;
            if (n == 2) {
                dp[2] = 2;
            } else if (n >= 3) {
                dp[2] = 2;
                dp[3] = 3;
            }

            for (int i = 4; i <= n; i++) {
                dp[i] = Math.min(Math.min(dp[i - 1] + 1, dp[i - 2] + 2), dp[i - 3] + 3);
                for (int j = 2; squareNum[j] <= i && squareNum[j] != -1; j++) {
                    dp[i] = Math.min(dp[i], dp[i - squareNum[j]] + 1);
                }
            }
            System.out.println(dp[n]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}