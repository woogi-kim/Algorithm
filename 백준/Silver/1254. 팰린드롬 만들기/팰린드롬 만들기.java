import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        int n = s.length();

        int maxPalindromeLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int palindromeLen = getPaliindromeLength(s.substring(i));
            maxPalindromeLength = Math.max(maxPalindromeLength, palindromeLen);
        }

        System.out.println(s.length() - maxPalindromeLength + s.length());
    }

    private static int getPaliindromeLength(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return 0;
            }
        }
        return s.length();
    }


}