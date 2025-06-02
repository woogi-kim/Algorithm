import java.util.*;

class Solution {
    public static int[] dp;
    
    public int solution(int n, int[] money) {
        dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < money.length; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }    
        }
        
        System.out.println(Arrays.toString(dp));
        
        return 0;
    }
}