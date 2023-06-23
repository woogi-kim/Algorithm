import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] input;
    public static int[][] dp;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < n; i++) {
            try {
                int num = Integer.parseInt(bufferedReader.readLine());
                input = new int[2][num + 1];
                dp = new int[3][num + 1];
                for (int j = 0; j < 2; j++) {
                    StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                    int k = 1;
                    while (st.hasMoreTokens()) {
                        input[j][k] = Integer.parseInt(st.nextToken());
                        k++;
                    }
                }
                dp[0][1] = 0;
                dp[1][1] = input[0][1];
                dp[2][1] = input[1][1];
                for (int j = 2; j <= num; j++) {
                    dp[0][j] = Math.max(Math.max(dp[0][j - 1], dp[1][j - 1]), dp[2][j - 1]);
                    dp[1][j] = Math.max(dp[0][j - 1], dp[2][j - 1]) + input[0][j];
                    dp[2][j] = Math.max(dp[0][j - 1], dp[1][j - 1]) + input[1][j];
                }
                System.out.println(Math.max(Math.max(dp[0][num], dp[1][num]), dp[2][num]));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
