import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int h;
    public static ArrayList<Integer>[] arr;
    public static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        h = Integer.parseInt(s[2]);

        arr = new ArrayList[n];
        dp = new int[n + 1][h + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            s = bf.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i].add(Integer.parseInt(s[j]));
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < arr[i - 1].size(); j++) {

                for (int k = 1; k <= h; k++) {
                    if (j == 0) {
                        dp[i][k] = dp[i - 1][k];
                    }
                    if (k - arr[i - 1].get(j) >= 0) {
                        dp[i][k] += dp[i - 1][k - arr[i - 1].get(j)];
                        dp[i][k] %= 10007;
                    }
                }
            }
        }


        System.out.println(dp[n][h]);


    }


}