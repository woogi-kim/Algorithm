import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] input;
    public static int[] dp;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        dp = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int e = 0;
        int s = 0;
        int sum = 0;
        while (true) {
            if (sum >= m) {
                sum -= input[s];
                s++;
            } else if (e == n) {
                break;
            } else {
                sum += input[e];
                e++;
            }
            if (sum == m) {
                ans++;
            }
        }
        System.out.println(ans);
    }

}
