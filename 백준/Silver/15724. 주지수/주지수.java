
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] input;
    public static long[][] dp;
    public static int n;
    public static int m;
    public static int k;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        sb = new StringBuilder();

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        input = new int[n + 1][m + 1];
        dp = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                input[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int j = 1; j <= m; j++) {
                tmp += input[i][j];
                dp[i][j] = dp[i - 1][j] + tmp;
            }
        }

        k = Integer.parseInt(bf.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(dp[x2][y2] + dp[x1 - 1][y1 - 1] - dp[x2][y1 - 1] - dp[x1 - 1][y2]).append('\n');
        }
        System.out.print(sb.toString());

    }


}
