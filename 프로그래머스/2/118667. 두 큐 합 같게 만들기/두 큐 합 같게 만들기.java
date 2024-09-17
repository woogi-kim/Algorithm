import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();       
        Queue<Long> q2 = new LinkedList<>();       
        
        long sum1 = 0;
        long sum2 = 0;
        
        int n = queue1.length;
        for (int i = 0; i < n; i++) {
            q1.add((long) queue1[i]);
            q2.add((long) queue2[i]);
            
            sum1 += (long) queue1[i];
            sum2 += (long) queue2[i];
        }
        
        int answer = -1;
        
        for (int i = 0; i < 4 * n; i++) {
            if (sum1 > sum2) {
                long top = q1.poll();
                q2.add(top);
                sum1 -= top;
                sum2 += top;
            } else if (sum1 < sum2) {
                long top = q2.poll();
                q1.add(top);
                sum2 -= top;
                sum1 += top;
            } else {
                answer = i;
                break;
            }
        }
               
        return answer;
    }
}