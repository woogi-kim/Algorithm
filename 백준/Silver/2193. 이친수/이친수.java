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
        dp = new long[n + 1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][0];
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        }
        long ans = dp[n][0] + dp[n][1];
        System.out.println(ans);
    }
}
