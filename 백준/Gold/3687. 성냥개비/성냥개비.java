import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n;
    public static long[] digits;
    public static long[] selection;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        digits = new long[101];
        digits[2] = 1;
        digits[3] = 7;
        digits[4] = 4;
        digits[5] = 2;
        digits[6] = 6;
        digits[7] = 8;

        selection = new long[8];
        selection[2] = 1;
        selection[3] = 7;
        selection[4] = 4;
        selection[5] = 2;
        selection[6] = 0;
        selection[7] = 8;
        bottomUp();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(bf.readLine());
            long min = digits[n];


            sb.append(min).append(' ').append(getMax(n)).append('\n');
        }

        System.out.println(sb);
    }

    public static void bottomUp() {
        for (int i = 8; i < 101; i++) {
            long tmp = Long.MAX_VALUE;
            for (int j = 2; j <= 7; j++) {
                StringBuilder sb = new StringBuilder();
                if (i - j < 2) {
                    continue;
                }

                sb.append(digits[i - j]).append(selection[j]);
                tmp = Math.min(tmp, Long.parseLong(sb.toString()));
            }
            digits[i] = tmp;
        }
    }

    public static String getMax(int num) {
        StringBuilder sb = new StringBuilder();
        if (num % 2 == 1) {
            sb.append(7);
            num -= 3;
        }
        for (int i = 0; i < num / 2; i++) {
            sb.append(1);
        }
        return sb.toString();
    }

}
