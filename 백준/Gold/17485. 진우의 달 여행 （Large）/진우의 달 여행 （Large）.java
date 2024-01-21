
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int m;
    public static int ans = Integer.MAX_VALUE;
    public static int[][] arr;
    public static int[][][] dp;
    public static int[] direction = {-1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            s = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], 1000001);
            }
        }

        for (int i = 0; i < m; i++) {
            dp[0][i][0] = arr[0][i];
            dp[0][i][1] = arr[0][i];
            dp[0][i][2] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j][1] = dp[i - 1][j][2] + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + arr[i][j];
                } else if (j == m - 1) {
                    dp[i][j][1] = dp[i - 1][j][0] + arr[i][j];
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][2], dp[i - 1][j - 1][1]) + arr[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][2], dp[i - 1][j - 1][1]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + arr[i][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[n - 1][i][j]);
            }
        }

        System.out.println(ans);
    }

}



