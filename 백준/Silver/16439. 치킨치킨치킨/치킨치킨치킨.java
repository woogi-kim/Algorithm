import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int ans;
    public static int[][] input;
    public static boolean[] isIncluded;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        input = new int[n][m];

        isIncluded = new boolean[m];

        Arrays.fill(isIncluded, false);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                input[i][j] = tmp;
            }
        }

        solve(0, 0);
        System.out.println(ans);
    }

    public static void solve(int start, int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int tmp = 0;
                for (int j = 0; j < m; j++) {
                    if (isIncluded[j]) {
                        tmp = Math.max(tmp, input[i][j]);
                    }
                }
                sum += tmp;
            }
            ans = Math.max(ans, sum);

            return;
        }
        for (int i = start; i < m; i++) {
            if (isIncluded[i]) {
                continue;
            }
            isIncluded[i] = true;
            solve(start + 1, depth + 1);
            isIncluded[i] = false;
        }
    }


}


