import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int m;
    public static int[][] dp;
    public static int[] memory;
    public static int[] deactivate;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        memory = new int[n];
        deactivate = new int[n];

        s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(s[i]);
        }

        s = bf.readLine().split(" ");
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            deactivate[i] = Integer.parseInt(s[i]);
            totalCost += deactivate[i];
        }


        dp = new int[n][totalCost + 1];
        for (int i = deactivate[0]; i <= totalCost; i++) {
            dp[0][i] = memory[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= totalCost; j++) {
                if (j - deactivate[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - deactivate[i]] + memory[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= totalCost; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[j][i] >= m) {
                    System.out.println(i);
                    return;
                }
            }
        }

    }
}