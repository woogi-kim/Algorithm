import java.util.*;

class Solution {
    public static int[] lion = new int[11];
    public static int[] answer = {-1};
    public static int max = Integer.MIN_VALUE;
    
    
    public int[] solution(int n, int[] info) {
        backtracking(0, n, info);
        
        if (max == -1) {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
    
    public void backtracking(int depth, int n, int[] info) {
        if (depth == n) {
            int diff = getScoreDiff(info);
            if (max <= diff) {
                max = diff;
                answer = lion.clone();
            }
            
            return;
        }
        
        for(int i = 0; i < info.length && lion[i] <= info[i]; i++) {
            lion[i] += 1;
            backtracking(depth + 1, n, info);
            lion[i] -= 1;
        }
    }
    
    public int getScoreDiff(int[] info) {
        int apeachScore = 0;
        int lionScore = 0;
        
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && lion[i] == 0 ) {
                continue;
            }
            
            if (lion[i] <= info[i]) {
                apeachScore += (10 - i);
            } else {
                lionScore += (10 - i);
            }
        }
        
        int diff = lionScore - apeachScore;
        
        if (diff <= 0) {
            return -1;
        } else {
            return diff;
        }
    }
}