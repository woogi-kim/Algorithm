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
            input = new int[n + 1];
            dp = new int[n + 1];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

            for (int i = 1; i <= n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1] + input[i], input[i]);
            }

            int max = dp[1];
            for (int i = 2; i <= n; i++) {
                max = Math.max(max, dp[i]);
            }

            System.out.println(max);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
