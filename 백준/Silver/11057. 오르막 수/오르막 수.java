import javax.lang.model.SourceVersion;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static long[][] dp;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        try {
            n = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dp = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                long sum = 0;
                for (int k = 0; k <= j; k++) {
                    sum = (sum + dp[i - 1][k]) % 10007;
                }
                dp[i][j] = sum;
            }
        }
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i];
            ans %= 10007;
        }
        System.out.println(ans);
    }
}
