import java.util.*;

class Solution {
    // 시간 복잡도 제한 없음
    // 서버가 알아서 줄어드는 걸 모방해야함.
    // k칸만 미리 쭉 증가시켜놓으면 비슷해짐
    // 증설되어잇어야하는 서버 갯수는 유저수 / m => 몫
    public static int[] servers;
    public int solution(int[] players, int m, int k) {
        servers = new int[players.length];
        
        int addCount = 0;
        
        for (int i = 0; i < players.length; i++) {
            int currentServerCount = servers[i];
            int targetServerCount = (players[i] / m);
            
            // 현재 증설된 서버로 감당 불가능한 경우
            if (currentServerCount < targetServerCount) {
                int needServerCount = targetServerCount - currentServerCount;
                
                addCount += needServerCount;
                
                for (int j = 0; j < k; j++) {
                    if (i + j < players.length) {
                        servers[i + j] += needServerCount;
                    }
                }
            } 
        }
        
        return addCount;
    }
}