import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int c, n;
    public static int[][] marketing;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        c = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);

        marketing = new int[n + 1][2];

        int maxCustomer = -1;
        for (int i = 1; i <= n; i++) {
            s = bf.readLine().split(" ");
            int cost = Integer.parseInt(s[0]);
            int customer = Integer.parseInt(s[1]);

            marketing[i][0] = cost;
            marketing[i][1] = customer;

            maxCustomer = Math.max(maxCustomer, customer);
        }

        dp = new int[c + maxCustomer];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int len = dp.length;

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - marketing[j][1] < 0) {
                    continue;
                }

                if (dp[i - marketing[j][1]] == Integer.MAX_VALUE) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - marketing[j][1]] + marketing[j][0]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = c; i < len; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);
    }


}