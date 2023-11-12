import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int ans = Integer.MAX_VALUE;
    public static int n, s;
    public static int[] input;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        s = Integer.parseInt(tmp[1]);
        input = new int[n];
        tmp = bf.readLine().split(" ");
        for (int i = 0; i < tmp.length; i++) {
            input[i] = Integer.parseInt(tmp[i]);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        while (true) {
            if (start == n) {
                break;
            }
            if (sum >= s) {
                sum -= input[start];
                start++;
                ans = Math.min(ans, end - start + 1);
            } else if (end == n) {
                start++;
            } else {
                sum += input[end];
                end++;
            }

        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

}
