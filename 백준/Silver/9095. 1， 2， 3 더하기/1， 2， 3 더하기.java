import java.io.*;
import java.util.Scanner;

public class Main {
    public static int[] dp;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            int number;
            int maxNum = 4;
            dp = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 0; i < n; i++) {
                number = Integer.parseInt(bufferedReader.readLine());
                for (int j = maxNum; j <= number; j++) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }
                System.out.println(dp[number]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}