import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] dp;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            dp = new int[n + 1];

            dp[0] = 1;
            if (n >= 2)
                dp[2] = 3;

            for (int i = 4; i <= n; i += 2) {
                dp[i] += dp[i - 2] * 3;
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += dp[j] * 2;
                }
            }

            System.out.println(dp[n]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}