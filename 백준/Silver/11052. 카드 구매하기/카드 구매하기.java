import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dp;
    public static int[] input;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            input = new int[n + 1];
            dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] = Math.max(dp[i - j] + input[j], dp[i]);
                }
            }
            System.out.println(dp[n]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}