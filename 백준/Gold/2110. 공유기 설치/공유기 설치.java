import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, c;
    public static long[] arr;
    public static long max;
    public static long min;
    public static long mid;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new long[n];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            arr[i] = input;
        }

        Arrays.sort(arr);
        max = arr[n - 1] - arr[0];
        min = 1;
        long d = 0;
        long ans = 0;
        while (max >= min) {
            mid = (max + min) / 2;
            long sum = 1;
            long start = arr[0];
            for (int i = 0; i < n; i++) {
                d = arr[i] - start;
                if (d >= mid) {
                    sum++;
                    start = arr[i];
                }
            }

            if (sum >= c) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
