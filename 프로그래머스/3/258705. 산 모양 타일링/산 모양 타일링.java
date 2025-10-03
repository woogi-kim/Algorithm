import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int[] height = new int[2 * n + 2];
        Arrays.fill(height, 1);
        
        for (int i = 2; i < 2 * n + 2; i+= 2) {
            if (tops[i / 2 - 1] == 1) {
                height[i] = 2;
            }
        }
        
        int[] dp = new int[2 * n + 2];
        dp[1] = 1;
        dp[2] = height[2] == 2 ? 3 : 2;
    

        
        for (int i = 3; i < 2 * n + 2; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i - 1] + dp[i - 2];
                
             } else{ 
                if (height[i] == 2) {
                    dp[i] = 2 * dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }   
            dp[i] %= 10007;
        }
        
        return dp[2 * n + 1];
        
    }
    
//     public static int search(int index) {
        
//     }
}