import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int n;
    public static int[] arr;
    public static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        String[] s = bf.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            ans += binarySearch(i);
        }

        System.out.println(ans);

    }

    private static long binarySearch(int i) {
        int left = i;
        int right = n - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[i] >= arr[mid] * 0.9) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - i - 1;

    }
}