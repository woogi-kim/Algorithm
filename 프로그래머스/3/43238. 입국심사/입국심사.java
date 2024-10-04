import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long hi = Integer.MIN_VALUE;
        for (int i = 0; i < times.length; i++) {
            hi = Math.max(hi, (long) n * (long) times[i]);
        }
        hi++;
        long lo = 0;
        
        while (lo + 1 < hi) {
            
            long mid = (lo + hi) / 2;
            System.out.println("mid: " + mid);
            
            if (canFinishInTime((long) n, mid ,times)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        return hi;
    }
    
    boolean canFinishInTime(long n, long mid, int[] times) {
        long traveler = 0;
        for (int i = 0; i < times.length; i++) {
            traveler += (mid / times[i]); 
        }
        
        return traveler >= n;
    }
}