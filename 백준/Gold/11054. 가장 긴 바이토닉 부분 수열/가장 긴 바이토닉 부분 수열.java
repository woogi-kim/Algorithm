import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] input;
    public static int[][] dp;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            input = new int[n + 1];
            dp = new int[2][n + 1];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

            for (int i = 1; i <= n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                dp[0][i] = 1;
                dp[1][i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i - 1; j++) {
                    if (input[i] > input[j])
                        dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
                    if (input[n - i + 1] > input[n - j + 1]) {
                        dp[1][n - i + 1] = Math.max(dp[1][n - i + 1], dp[1][n - j + 1] + 1);
                    }
                }
            }

            int max = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(dp[0][i] + dp[1][i] - 1, max);
            }
            System.out.println(max);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}