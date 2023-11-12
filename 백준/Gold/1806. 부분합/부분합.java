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
        input = new int[n + 1];
        tmp = bf.readLine().split(" ");
        for (int i = 0; i < tmp.length; i++) {
            input[i] = Integer.parseInt(tmp[i]);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        while (end <= n && start <= n) {
            if (sum < s) {
                sum += input[end];
                end++;
            } else {
                ans = Math.min(ans, end - start);
                sum -= input[start];
                start++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

}
