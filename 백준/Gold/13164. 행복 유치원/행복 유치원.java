import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long ans;
    public static int n;
    public static int k;
    public static int[] input;
    public static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        input = new int[n];
        diff = new int[n - 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - 1; i++) {
            diff[i] = input[i + 1] - input[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < n - k; i++) {
            ans += diff[i];
        }
        System.out.println(ans);
    }


}


