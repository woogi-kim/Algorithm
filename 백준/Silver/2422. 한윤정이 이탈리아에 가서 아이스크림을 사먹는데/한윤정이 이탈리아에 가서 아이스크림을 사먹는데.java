import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int ans;
    public static boolean[][] notAllowed;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        notAllowed = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(notAllowed[i], false);
        }

        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            int source = Integer.parseInt(s[0]);
            int target = Integer.parseInt(s[1]);
            notAllowed[source][target] = true;
            notAllowed[target][source] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!notAllowed[i][j]) {
                    for (int k = j + 1; k <= n; k++) {
                        if (!notAllowed[i][k] && !notAllowed[j][k]) {
                            ans++;
                        }
                    }
                }

            }
        }
        System.out.println(ans);

    }


}


