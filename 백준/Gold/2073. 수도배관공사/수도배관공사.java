import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int d, p;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        d = Integer.parseInt(s[0]);
        p = Integer.parseInt(s[1]);
        dp = new int[d + 1];
        dp[0]= Integer.MAX_VALUE;

        for (int i = 1; i <= p; i++) {
            s = br.readLine().split(" ");
            // 0 은 길이 1는 용량
            int length = Integer.parseInt(s[0]);
            int capacity = Integer.parseInt(s[1]);
            for (int j = d; j >= length; j--) {
                dp[j] = Math.max(dp[j], Math.min(capacity, dp[j - length]));
            }

        }

        
        System.out.println(dp[d]);
    }


}




