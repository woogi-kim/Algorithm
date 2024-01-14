
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] coins;
    public static int[] dp;
    public static int n;
    public static int t;
    public static int m;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        while (t > 0) {
            t--;
            n = Integer.parseInt(bf.readLine());
            coins = new int[n];
            String[] s = bf.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(s[i]);
            }
            m = Integer.parseInt(bf.readLine());
            dp = new int[m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= m; j++) {
                    if (j - coins[i] == 0) {
                        dp[j] += 1;
                    } else {
                        dp[j] += dp[j - coins[i]];
                    }
                }
            }

            System.out.println(dp[m]);
        }

    }


}
