import java.util.*;
class Solution {
    public static boolean possible;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            possible = true;
            String tmp = deciamlToBinary(numbers[i]);
            recur(tmp);
            
            answer[i] = possible ? 1 : 0;
        }
        return answer;
    }
    
    public static boolean recur (String num) {
        if (num.length() == 1) {
            return num.equals("1");
        }
        
        // System.out.println(num.substring(0, num.length() / 2));
        // System.out.println(num.substring(num.length() / 2 + 1, num.length()));
        boolean first = recur(num.substring(0, num.length() / 2));
        boolean second = recur(num.substring(num.length() / 2 + 1, num.length()));
        
        if (num.charAt(num.length() / 2) == '0' && (first || second)) {
         possible = false;
        } 
        
        return first || second || num.charAt(num.length() / 2)=='1';
    }
    
    public static String deciamlToBinary(long n) {
        StringBuilder sb = new StringBuilder();
                                                 
        while (n != 0) {
            sb.append(n % 2);
            n /= 2;
        }
        
        int len = sb.length();
        
        int digits = 1;
        int k = 1;
        while (true) {
            digits = (int) Math.pow(2, k) - 1;
            
            if (digits >= len) {
                break;
            }
            k++;
        }
        
        for (int i = 0; i < digits - len; i++) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }
}