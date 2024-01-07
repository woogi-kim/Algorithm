import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static int n;
    public static int k;
    public static int[] input;
    public static boolean[] isIncluded;
    public static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        k = Integer.parseInt(bf.readLine());
        input = new int[n];
        isIncluded = new boolean[n];
        Arrays.fill(isIncluded, false);
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(bf.readLine());
        }
        solve(0, "");
        System.out.println(set.size());
    }

    public static void solve(int depth, String current) {
        if (depth == k) {
            set.add(current);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isIncluded[i]) {
                continue;
            }
            isIncluded[i] = true;
            solve(depth + 1, current + input[i]);
            isIncluded[i] = false;
        }
    }


}


