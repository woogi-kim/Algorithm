import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static Long t;
    public static int n;
    public static int m;
    public static int[] a;
    public static int[] b;

    public static long[] aAccumulate;
    public static long[] bAccumulate;

    public static long[] bSubArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Long.parseLong(bf.readLine());

        n = Integer.parseInt(bf.readLine());

        String[] s = bf.readLine().split(" ");
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        m = Integer.parseInt(bf.readLine());

        s = bf.readLine().split(" ");
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(s[i]);
        }

        aAccumulate = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            aAccumulate[i] = aAccumulate[i - 1] + a[i - 1];
        }

        bAccumulate = new long[m + 1];

        for (int i = 1; i <= m; i++) {
            bAccumulate[i] = bAccumulate[i - 1] + b[i - 1];
        }

        Map<Long, Integer> bMap = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                long sumSubArray = bAccumulate[i] - bAccumulate[j];
                if (bMap.containsKey(sumSubArray)) {
                    bMap.put(sumSubArray, bMap.get(sumSubArray) + 1);
                } else {
                    bMap.put(sumSubArray, 1);
                }
            }
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                long target = t - (aAccumulate[i] - aAccumulate[j]);
                if (bMap.containsKey(target)) {
                    ans += bMap.get(target);
                }
            }
        }

        System.out.println(ans);
    }

}