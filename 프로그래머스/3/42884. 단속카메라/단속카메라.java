import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int car = routes.length;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int answer = 1;
        int camPos = routes[0][1];
        
        for (int i = 1; i < car; i++){
            if (camPos >= routes[i][0]) {
                continue;
            } else {
                camPos = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}