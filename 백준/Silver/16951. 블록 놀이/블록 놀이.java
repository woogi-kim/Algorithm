import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int k;
    public static int[] towers;
    public static int target;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        towers = new int[n];

        s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < n; i++) {
            int count = 0;

            target = towers[i];
            for (int j = i - 1; j >= 0; j--) {
                target -= k;
                if (target != towers[j]) {
                    count++;
                }
            }

            if (target <= 0) {
                continue;
            }

            target = towers[i];
            for (int j = i + 1; j < n; j++) {
                target += k;
                if (target != towers[j]) {
                    count++;
                }
            }

            ans = Math.min(count, ans);
        }

        System.out.println(ans);
    }
}