import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int originalSize = s.length();
        
        if (s.length() == 1) {
            return 1;
        }
        
        for (int i = 1; i < (originalSize / 2) + 1; i++) {
            String result = "";
            
            String current = "";
            int count = 0;
            
            int j = 0;
            for (j = 0; j < originalSize; j += i) {
                String sub = s.substring(j, Math.min(originalSize, j + i));
                // System.out.print(s.substring(j, Math.min(originalSize, j + i)) + "/");
                if (current.equals(sub)) {
                    count++;
                } else {
                    if (count > 1) {
                        result += count;
                    } 
                    result += current;
                    current = sub;
                    count = 1;
                }
            }
            
            if (count > 1) {
                result += count;
            } 
            result += current;
            
            // System.out.println();
            answer = Math.min(answer, result.length());
            // System.out.println("---" + result + "---");
        }
        return answer;
    }
}