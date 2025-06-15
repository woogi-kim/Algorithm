import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.add(work);
        }
        
        for (int i = 0; i < n; i++) {
            int cur = pq.poll();
            
            pq.add(cur - 1 >= 0 ? cur - 1 : 0);
        }
        
        long ans = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            ans += (long) (cur * cur);
        }
        
        return ans;
    }
}