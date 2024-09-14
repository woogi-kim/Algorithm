import java.util.*;


class Solution {
    public int[] solution(String s) {
        String setList = s.substring(1, s.length() - 1);
        
        PriorityQueue<String> sets = new PriorityQueue<>((s1, s2) -> s1.length() - s2.length());
        
        int startOfSet = 1;
        String set = "";
        for(int i = 1; i < setList.length(); i++) {
            if (setList.charAt(i) == '}') {
                sets.add(setList.substring(startOfSet, i));
                
                i += 3;
                startOfSet = i; 
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        while (!sets.isEmpty()) {
            String currentSet = sets.poll();
            
            String[] numbers = currentSet.split(",");
            
            for(String number : numbers) {
                int temp = Integer.parseInt(number);
                
                if (!answerList.contains(temp)) {
                    answerList.add(temp);
                    break;
                }
            }
        }
                
        return convertListToArray(answerList);
    }
    
    
    public int[] convertListToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}