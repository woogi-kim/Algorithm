import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int t, w;
    public static int[] plum;
    public static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        t = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);
        plum = new int[t + 1];
        dp = new int[t + 1][3][w + 2];

        for (int i = 1; i <= t; i++) {
            plum[i] = Integer.parseInt(bf.readLine());
        }

//        if (plum[1] == 1) {
//            dp[1][1][1] = 1;
//        } else {
//            dp[1][2][2] = 1;
//        }


        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= w + 1; j++) {
                if (plum[i] == 1) {
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][2][j - 1]) + 1;
                    dp[i][2][j] = Math.max(dp[i - 1][2][j], dp[i - 1][1][j - 1]);
                } else {
                    if (i == 1 && j == 1) continue;
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][2][j - 1]);
                    dp[i][2][j] = Math.max(dp[i - 1][2][j], dp[i - 1][1][j - 1]) + 1;
                }

            }
        }
        int ans = 0;
        for (int i = 1; i <= w + 1; i++) {
            for (int j = 1; j <= 2; j++) {
                ans = Math.max(dp[t][j][i], ans);
            }
        }
        System.out.println(ans);
//        for (int i = 1; i <= w + 1; i++) {
//            for (int j = 1; j <= t; j++) {
//                for (int k = 1; k <= 2; k++) {
//                    System.out.print(dp[j][k][i] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("------");
//        }
    }


}