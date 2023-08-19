import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static long[] length;
    public static long max = 1;
    public static long min = 0;
    public static long mid;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        length = new long[n];

        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            max = Math.max(input, max);
            length[i] = input;
        }
        max++;
        while (max >= min) {
            mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (length[i] - mid > 0) {
                    sum += (length[i] - mid);
                }
                if (sum > m)
                    break;
            }

            if (sum >= m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}
