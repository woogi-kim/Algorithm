import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        int countB = 0;
        int countR = 0;
        char currentChar = s.charAt(0);
        int currentCount = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != currentChar) {
                if (currentChar == 'B') {
                    countB++;
                    currentCount = 1;
                    currentChar = 'R';
                } else {
                    countR++;
                    currentCount = 1;
                    currentChar = 'B';
                }
            }
        }
        if (currentChar == 'B') {
            countB++;
            currentCount = 1;
            currentChar = 'R';
        } else {
            countR++;
            currentCount = 1;
            currentChar = 'B';
        }
        System.out.println(Math.min(countB,countR) + 1);
    }

}