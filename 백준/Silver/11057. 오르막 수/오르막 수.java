import java.util.Scanner;

public class Main {
    public static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
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
        }
        System.out.println(ans % 10007);
    }
}
