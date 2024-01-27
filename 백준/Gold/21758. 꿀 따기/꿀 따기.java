
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] sum;
    public static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        sum = new int[n];
        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, sum[i - 1] + sum[n - 2] - arr[i]);
            ans = Math.max(ans, sum[n - 1] - arr[i] - arr[0] + sum[n - 1] - sum[i]);
            ans = Math.max(ans, sum[i] - arr[0] + sum[n - 2] - sum[i - 1]);
        }
        System.out.println(ans);
    }

}



