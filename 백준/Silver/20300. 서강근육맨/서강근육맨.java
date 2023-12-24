import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static long ans;
    public static Long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new Long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        if (n % 2 == 0) {
            ans = Long.MIN_VALUE;
            for (int i = 0; i < n / 2; i++) {
                ans = Math.max(ans, arr[i] + arr[n - 1 - i]);
            }
        } else {
            ans = arr[n - 1];
            for (int i = 0; i < n / 2; i++) {
                ans = Math.max(ans, arr[i] + arr[n - 2 - i]);
            }
        }
        System.out.println(ans);
    }

}