import java.util.*;

class Solution {
    public static Map<String, Integer> friendsIndex;
    public static int[][] giftHistory;
    public static int[] estimation;
    public static int[] giftRate;
    
    public int solution(String[] friends, String[] gifts) {
        friendsIndex = new HashMap<>();
        
        for (int i = 0; i < friends.length; i++) {
            friendsIndex.put(friends[i], i);   
        }
            
        giftHistory = new int[friends.length][friends.length];
        giftRate = new int[friends.length];
        for (String gift : gifts) {
            String[] fromTo = gift.split(" ");
            
            int a = friendsIndex.get(fromTo[0]);
            int b = friendsIndex.get(fromTo[1]);
            
            giftHistory[a][b]++;
            giftRate[a]++;
            giftRate[b]--;
        }
        
        estimation = new int[friends.length];
        
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                // 다르다면
                if (giftHistory[i][j] != giftHistory[j][i]) {
                    if (giftHistory[i][j] > giftHistory[j][i]) {
                        estimation[i]++;
                    } else {
                        estimation[j]++;
                    }
                } else {
                    if (giftRate[i] != giftRate[j]) {
                        if (giftRate[i] > giftRate[j]) {
                            estimation[i]++;
                        } else {
                            estimation[j]++;
                        }
                    } 
                }
            }
        }
        
        
        int answer = 0;
        for (int a : estimation) {
            answer = Math.max(a, answer);
        }
        return answer;
    }
}