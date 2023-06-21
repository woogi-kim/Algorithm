import java.io.*;
import java.util.Scanner;

public class Main {
    public static long[][] dp;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            dp = new long[n + 1][10];
            for (int i = 0; i < 9; i++) {
                dp[1][i] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][1] % 1000000000;
                    } else if (j == 9) {
                        dp[i][j] = dp[i - 1][8] % 1000000000;
                    } else {
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += dp[n][i];
            }
            System.out.println(sum % 1000000000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
