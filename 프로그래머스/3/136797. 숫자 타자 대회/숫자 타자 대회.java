// 빡구현 만으론 답이 없어보임
// 그리디도 안될 것 같음
// dp??
// dp[i][j][k] = 왼손으로 j, 오른손으로 k 를 누르고 있을 때 i까지 만들었을 때 최소값?
// 4 5 6
// 두개 중 오른쪽을 선택해야 최적
// 그리디는 안돼.
// dp
import java.util.*;

class Solution {
    public static int[][][] dp;
    public static int[][] costs = {
        {1,7,6,7,5,4,5,3,2,3},
        {7,1,2,4,2,3,5,4,5,6},
        {6,2,1,2,3,2,3,5,4,5},
        {7,4,2,1,5,3,2,6,5,4},
        {5,2,3,5,1,2,4,2,3,5},
        {4,3,2,3,2,1,2,3,2,3},
        {5,5,3,2,4,2,1,5,3,2},
        {3,4,5,6,2,3,5,1,2,4},
        {2,5,4,5,3,2,3,2,1,2},
        {3,6,5,4,5,3,2,4,2,1}
    };
    
    public int solution(String numbers) {
        dp = new int[numbers.length() + 1][10][10];
        // j, k를 각각 왼손 오른손 위치시켰을 때 i를 만드는 최적의 코스트
        for (int i = 0; i < numbers.length() + 1; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        int first = numbers.charAt(0) - '0';
        
        dp[0][4][6] = 0;
        
        // dp[i]= dp[i-1]
        for (int i = 0; i < numbers.length(); i++) {
            // dp[i] 의 값을 기반으로 dp[i + 1]을 채워나간다.
            int cur = numbers.charAt(i) - '0';
            
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (dp[i][j][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (j == k) continue;
                    
                    if (k != cur) {
                        dp[i + 1][cur][k] = Math.min(dp[i + 1][cur][k], dp[i][j][k] + costs[j][cur]);   
                    }
                    if (j != cur) {
                        dp[i + 1][j][cur] = Math.min(dp[i + 1][j][cur], dp[i][j][k] + costs[k][cur]);
                    }
                }
            }
        }
        
 
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                answer = Math.min(answer, dp[numbers.length()][i][j]);
            }
        }
        
        return answer;
    }
}