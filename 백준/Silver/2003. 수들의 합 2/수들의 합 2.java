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

        dp[0] = input[0];
        if (dp[0] == m) {
            ans++;
        }
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + input[i];
            if (dp[i] == m) {
                ans++;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[j] - dp[i - 1] == m) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}
