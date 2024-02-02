
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        recursive(num, 0);
        System.out.println(min + " " + max);
    }

    public static void recursive(String num, int oddCnt) {
        if (num.length() == 1) {
            int tmpOddCnt = getOddNumberCnt(num);
            min = Math.min(min, oddCnt + tmpOddCnt);
            max = Math.max(max, oddCnt + tmpOddCnt);
        } else if (num.length() == 2) {
            int tmpOddCnt = getOddNumberCnt(num);
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                int tmpNum = num.charAt(i) - '0';
                sum += tmpNum;
            }
            recursive(String.valueOf(sum), oddCnt + tmpOddCnt);

        } else if (num.length() == 3) {
            int tmpOddCnt = getOddNumberCnt(num);
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                int tmpNum = num.charAt(i) - '0';
                sum += tmpNum;
            }
            recursive(String.valueOf(sum), oddCnt + tmpOddCnt);
        } else {
            int tmpOddCnt = getOddNumberCnt(num);
            for (int i = 1; i < num.length() - 1; i++) {
                int tmpNum1 = Integer.parseInt(num.substring(0, i));
                for (int j = i + 1; j < num.length() ; j++) {
                    int tmpNum2 = Integer.parseInt(num.substring(i, j));
                    int tmpNum3 = Integer.parseInt(num.substring(j));
                    recursive(String.valueOf(tmpNum1 + tmpNum2 + tmpNum3), oddCnt + tmpOddCnt);
                }
            }
        }
    }

    public static int getOddNumberCnt(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}




