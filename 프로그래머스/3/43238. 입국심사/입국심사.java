import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long hi = ((long) times[times.length - 1] * n) + 1;
        long lo = 0;
        
        while (lo + 1 < hi) {
            System.out.println(lo + " " + hi);
            long mid = (hi + lo) / 2;
            
            if (canFinishInTime(mid, n, times)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
    
        return hi;
    }
    
    public boolean canFinishInTime(long mid, int n, int[] times) {
        long totalCount = 0;
        for (int i = 0; i < times.length; i++) {
            totalCount += mid / times[i];
        }
        
        return totalCount >= n;
    }
}