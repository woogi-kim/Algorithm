import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int k;
    public static int ans;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int nLength = s[0].length();
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        arr = new int[k];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve(0, 1, nLength+1);
        System.out.println(ans);
    }

    public static void solve(int currentNum, int currentDepth, int targetDepth) {
        if (currentDepth > targetDepth) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int newNum = currentNum * 10 + arr[i];
            if (newNum > n) {
                return;
            } else {
                ans = Math.max(ans, newNum);
                solve(newNum, currentDepth + 1, targetDepth);
            }
        }
    }
}




