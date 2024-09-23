import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        HashMap<String, Integer> set1 = new HashMap<>();
    
        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i,i + 2).toLowerCase();
            
            if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {
                if (str.charAt(1) >= 'a' && str.charAt(1) <= 'z') {
                    if (!set1.containsKey(str)) {
                        set1.put(str, 1);
                    } else {
                        set1.put(str, set1.get(str) + 1);
                    }
                }
            }
        }
       
        HashMap<String, Integer> set2 = new HashMap<>();
    
        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i,i + 2).toLowerCase();
            
            if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {
                if (str.charAt(1) >= 'a' && str.charAt(1) <= 'z') {
                    if (!set2.containsKey(str)) {
                        set2.put(str, 1);
                    } else {
                        set2.put(str, set2.get(str) + 1);
                    }
                }
            }
        }
        
        double interSectionSize = 0;
        for (String key : set1.keySet()) {
            if (set2.containsKey(key)) {
                interSectionSize += Math.min(set1.get(key), set2.get(key));
            }
        }
        
        double unionSize = 0;
        for (String key : set2.keySet()) {
            if (set1.containsKey(key)) {
                set1.put(key, Math.max(set1.get(key), set2.get(key)));
            } else {
                set1.put(key, set2.get(key));
            }
        }
        
        for (String key : set1.keySet()) {
            unionSize += set1.get(key);
        }
        

        double j = unionSize == 0 ? 1 : interSectionSize / unionSize;
        return (int) (j * 65536);
    }
}