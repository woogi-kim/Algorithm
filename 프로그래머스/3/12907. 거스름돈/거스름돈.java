import java.util.*;

class Solution {
    public static int[][] dp;
    
    public int solution(int n, int[] money) {
        // dp[i][j] = i번째 동전까지 써서 j원을 만드는 방법의 수
        dp = new int[money.length][n + 1];
        
        // 0원을 만드는 경우의 수는 전부 1로 설정
        for (int i = 0; i < money.length; i++) {
            dp[i][0] = 1;
        }
        
        // 만약, 첫 번째 동전과 나누어 떨어지는 금액이면 만들기 가능 => 1로 설정
        for (int i = 1; i <= n; i++) {
            if (i % money[0] == 0) {
                dp[0][i] = 1;
            }
        }
        
        for (int i = 1; i < money.length; i++) {
            for (int j = 1; j <= n; j++) {
                // i번째 동전을 사용하지 않더라도, i - 1번째 까지의 경우의 수는 그대로 내려와야함.
                dp[i][j] = dp[i - 1][j];
                
                if (j - money[i] >= 0) {
                    dp[i][j] += dp[i][j - money[i]];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        
        return dp[money.length - 1][n];
    }
}