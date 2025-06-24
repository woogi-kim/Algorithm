import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        Arrays.sort(data, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = Math.abs(data[i][0] - data[j][0]);
                int y = Math.abs(data[i][1] - data[j][1]);
                if ((long) x * y == 0) {
                    continue;
                } 
                
                boolean p = false;
                for (int k = i + 1; k < j; k++) {
                    if (include(data[i][0], data[i][1], data[j][0], data[j][1], data[k][0], data[k][1])) {
                        p = true;
                        break;
                    }
                }
                if (p) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }
    public static boolean include (int x1, int y1, int x2, int y2, int targetx, int targety) {
        int x = Math.min(x1, x2);
        int xx = Math.max(x1, x2);
        int y = Math.min(y1, y2);
        int yy = Math.max(y1, y2);
        return targetx > x && targetx < xx && targety > y && targety < yy;
    }
}