import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] s;
    public static int[] b;
    public static int ans = Integer.MAX_VALUE;
    public static boolean[] isChecked;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        s = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");
            s[i] = Integer.parseInt(tmp[0]);
            b[i] = Integer.parseInt(tmp[1]);
        }
        for (int i = 1; i <= n; i++) {
            isChecked = new boolean[n];
            solve(0, 0, i);
        }
        System.out.println(ans);
    }


    public static void solve(int depth, int start, int select) {
        if (depth == select) {
            int sMul = 0;
            int bSum = 0;
            for (int i = 0; i < n; i++) {
                if (isChecked[i]) {
                    sMul = sMul != 0 ? sMul * s[i] : s[i];
                    bSum += b[i];
                }
            }
            ans = Math.min(ans, Math.abs(sMul - bSum));
        } else {
            for (int i = start; i < n; i++) {
                if (!isChecked[i]) {
                    isChecked[i] = true;
                    solve(depth + 1, i + 1, select);
                    isChecked[i] = false;
                }
            }
        }
    }


}
