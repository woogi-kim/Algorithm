
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int result;
    public static int[] input;
    public static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        input = new int[n];
        dp = new long[n + 1][21];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n - 1; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        result = Integer.parseInt(st.nextToken());

        dp[1][input[1]] = 1;
        for (int i = 2; i <= n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                int sum = j + input[i];
                int sub = j - input[i];
                if (sum <= 20) {
                    dp[i][sum] += dp[i - 1][j];
                }
                if (sub >= 0) {
                    dp[i][sub] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 1][result]);
    }

}



