import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] input;
    public static int[] dp;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dp = new int[n + 1];
        input = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            try {
                input[i] = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        dp[1] = input[1];
        if (n > 1)
            dp[2] = input[1] + input[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 3] + input[i - 1] + input[i], dp[i - 2] + input[i]), dp[i - 1]);
        }
        System.out.println(dp[n]);
    }
}
