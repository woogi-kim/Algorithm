import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int k, n;
    public static long[] length;
    public static long max = 1;
    public static long min = 1;
    public static long mid = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        length = new long[k + 1];

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            max = Math.max(input, max);
            length[i] = input;
        }
        
        while (max >= min) {
            mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += (length[i] / mid);
                if (sum > n)
                    break;
            }

            if (sum >= n) {
                min = mid + 1;
            } else if (sum < n) {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}
