import java.util.*;

class Solution {
    // user_id가 매우 적음(8) -> 재귀 + 브루트 포스로 가능할지도?
    public static boolean[] isBanned;
    public static int answer;
    public static Set<Set<String>> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        isBanned = new boolean[user_id.length];
        set = new HashSet<>();
        
        recur(0, user_id, banned_id);
            
        return set.size();
    }
    
    public static void recur(int depth, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            Set<String> tmpSet = new HashSet<>();
            for (int i = 0; i < user_id.length; i++) {
                if (isBanned[i]) {
                    tmpSet.add(user_id[i]);    
                }
            }
            
            set.add(tmpSet);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            // 이미 밴된 사용자라면 스킵
            if (isBanned[i]) {
                continue;
            }
            
            // 길이가 다르면 매칭 불가능하니 스킵
            if (user_id[i].length() != banned_id[depth].length()) {
                continue;
            }
            
            // 매칭이 되는지 확인 로직
            boolean isMatched = true;
            for (int j = 0; j < user_id[i].length(); j++) {
                if ((user_id[i].charAt(j) != banned_id[depth].charAt(j)) && banned_id[depth].charAt(j) != '*') {
                    isMatched = false;
                    break;
                }
            }
            
            // 매칭된다면 재귀
            if (isMatched) {
                isBanned[i] = true;
                recur(depth + 1, user_id, banned_id);
                isBanned[i] = false;
            }
        }
    }
}