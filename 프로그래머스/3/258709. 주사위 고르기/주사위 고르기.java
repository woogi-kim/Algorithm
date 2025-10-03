import java.util.*;

class Solution {
    public static boolean[] visited;
    public static int n;
    public static int[] aDiceResult;
    public static int[] bDiceResult;
    
    public static int[] choosedA;
    public static int[] choosedB;
    
    public static int[][] dices;
    
    public static int[] answer;
    public static double maxWinRate = 0.0;
    
    public int[] solution(int[][] dice) {
        dices = dice;
        n = dice.length;
        visited = new boolean[n];
        
        comb(0, 0);
        
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;        
        }
    
        return answer;
    }
    public static void insertA(int depth, int sum) {
        if (depth == n / 2) {
            aDiceResult[sum]++;
            return;
        }   
        
        for (int i = 0; i < 6; i++) {
            insertA(depth + 1, sum + dices[choosedA[depth]][i]);
        }
    }
    
    public static void insertB(int depth, int sum) {
        if (depth == n / 2) {
            bDiceResult[sum]++;
            return;
        }   
        
        for (int i = 0; i < 6; i++) {
            insertB(depth + 1, sum + dices[choosedB[depth]][i]);
        }
    }
    
    public static void comb(int start, int count) {
        if (count == (n / 2)) {
            aDiceResult = new int[501];
            bDiceResult = new int[501];
            
            choosedA = new int[n / 2];
            choosedB = new int[n / 2];
            
            int aIdx = 0;
            int bIdx = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    choosedA[aIdx] = i;
                    aIdx++;
                } else {
                    choosedB[bIdx] = i;
                    bIdx++;
                }
            }
            insertA(0, 0);
            insertB(0, 0);
            
            int win = 0;
            for (int i = 0; i < 501; i++) {
                if (aDiceResult[i] == 0) {
                    continue;
                }
                for (int j = 0; j < 501; j++) {
                    if (bDiceResult[j] == 0) {
                        continue;
                    }
                    
                    if (i > j) {
                        win += aDiceResult[i] * bDiceResult[j];
                    }
                }
            }
            // System.out.println((double) win / (int) Math.pow(6, n));
            if (maxWinRate < (double) win / (int) Math.pow(6, n)) {
                answer = choosedA;
                maxWinRate = (double) win / (int) Math.pow(6, n);
            }
            
            return;
        }
        
        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(i + 1, count + 1);
            visited[i] = false;
        }
    }
}