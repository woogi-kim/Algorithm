import java.util.*;

class Solution {
    // 그냥 Map에 넣어서 확인.. => O(N)?
    // 투포인터?
    
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        
        int count = set.size();
        
        HashMap<String, Integer> map = new HashMap<>();
        
        
        
        int start = 0;
        
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if (map.size() == count) {
                if ((answer[1] - answer[0]) > (end - start)) {
                    answer[1] = end + 1;
                    answer[0] = start + 1;
                }
            }
        }
        
        return answer;
    }
}