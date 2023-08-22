import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static int n, k;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int maxCoinIdx = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (k >= arr[i]) {
                maxCoinIdx = i;
                break;
            }
        }

        while (k > 0) {
            if (arr[maxCoinIdx] <= k) {
                count += k / arr[maxCoinIdx];
                k %= arr[maxCoinIdx];
            }
            maxCoinIdx--;
        }
        System.out.println(count);
    }
}

