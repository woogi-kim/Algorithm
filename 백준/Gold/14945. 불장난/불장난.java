import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static int n;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        arr = new int[n + 1][n + 1];
        arr[2][1] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = (2 * arr[i - 1][j] + arr[i - 1][j + 1] + arr[i - 1][j - 1]) % 10007;
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += arr[n][i];
        }
        System.out.println(ans % 10007);

    }

}