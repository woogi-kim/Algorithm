// 1번째 비트열 : 11011

// 2번째 비트열 : 11011 11011 00000 11011 11011

// 3번째 비트열 : 11011 11011 00000 11011 11011
//             11011 11011 00000 11011 11011
//             00000 00000 00000 00000 00000
//             11011 11011 00000 11011 11011
//             11011 11011 00000 11011 11011

// 길이가 최대 5^20 (> 10^12)
// 완탐 X
// s[n] = 2 * s[n - 1] + "0" * 5^(n-1) + 2 * s[n - 1];

// 2/5 ~ 3/5 지점이 아닐 때
// isOne(n, i) = isOne(n - 1, i / 5^(n-1))
// 아 근데 1000만개를 재귀를 일일이 다 타늑ㄴ게 맞을까?
// 20번 => 2억... 얼추 가능?

// 반복되는 패턴이 있긴한데... 구간이 어디에 걸쳐있는지에 대한 경우가 너무 많아서 사용하긴 힘들 것 같음.

// 캐싱도 map으로 해봤는데 메모리 초과남

import java.util.*;

class Solution {
    public static Map<String, Boolean> map;
    
    public int solution(int n, long l, long r) {
        // map = new HashMap<>();
        // map.put("1 1", true);
        // map.put("1 2", true);
        // map.put("1 3", false);
        // map.put("1 4", true);
        // map.put("1 5", true);
        
        int answer = 0;
        
        for (long i = l; i <= r; i++) {
            if (i > 2 * Math.pow(5, n) / 5 && i <= 3 * Math.pow(5, n) / 5) {
                // System.out.println(i +" 는 무조건 0");
                continue;
            }
            
            if (isOne(n, i)) {
                // System.out.println(i +" 는 1");
                answer++;
            } else {
                // System.out.println(i +" 는 0");
            }
        }
        return answer;
    }
    
    public static boolean isOne(int n, long i) {
        // if (map.containsKey(n + " "+ i)) {
            // return map.get(n + " "+ i);
        // }
        
        if (n == 1) { //11011
            if (i == 3) {
                return false;
            }
            return true;
        }
        if (i > 2 * Math.pow(5, n) / 5 && i <= 3 * Math.pow(5, n) / 5) {
            return false;
        }
        boolean res = isOne(n - 1, i % (long) Math.pow(5, n - 1));
        // System.out.println((n - 1) + " " + (i % (long) Math.pow(5, n - 1)));
        
        // map.putIfAbsent((n - 1) + " " + (i % (long) Math.pow(5, n - 1)), res);
        return res;
    }
}