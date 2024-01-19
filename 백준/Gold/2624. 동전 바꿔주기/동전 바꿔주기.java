
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int t;
    public static int k;
    public static int[][] dp;
    public static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        k = Integer.parseInt(bf.readLine());
        input = new int[k + 1][2];
        dp = new int[k + 1][t + 1];
        for (int i = 1; i <= k; i++) {
            String[] s = bf.readLine().split(" ");
            input[i][0] = Integer.parseInt(s[0]);
            input[i][1] = Integer.parseInt(s[1]);
        }

        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= input[i][1]; j++) {
                int coinValue = input[i][0];
                for (int k = 0; k <= t; k++) {
                    int currentMoney = k + coinValue * j;
                    if (currentMoney > t) {
                        break;
                    }
                    dp[i][currentMoney] += dp[i - 1][k];
                }
            }
        }
        System.out.println(dp[k][t]);
    }

}



