import java.util.*;

class Solution {
    int sign = Integer.MIN_VALUE;
    int earn = Integer.MIN_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] discount = new int[emoticons.length];
        
        comb(0, emoticons.length, discount, users, emoticons);
        
        int[] answer = {sign, earn};
        
        return answer;
    }
    
    public void comb(int depth, int end, int[] discount, int[][] users, int[] emoticons) {
        if (depth == end) {
            calc(discount, users, emoticons);        
            return;
        } else {
           for(int i = 10; i <= 40; i += 10) {
               discount[depth] = i;
               comb(depth + 1, end, discount, users, emoticons);
           } 
        }
    }
    
    public void calc(int[] discount, int[][] users, int[] emoticons) {
        
        int totalSign = 0;
        int totalEarn = 0;
        
        for (int i = 0; i < users.length; i++) {
            
            int userSign = 0;
            int userEarn = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if (discount[j] >= users[i][0]) {
                    userEarn += (emoticons[j] * ((100 - discount[j]) * 0.01));
                }
            }
            
            if (userEarn >= users[i][1]) {
                totalSign += 1;
            } else {
                totalEarn += userEarn;
            }
            
        }
        
        
        if (sign < totalSign) {
            sign = totalSign;
            earn = totalEarn;
        } else if (sign == totalSign) {
            if (earn < totalEarn) {
                earn = totalEarn;
            }
        } 
    }
}