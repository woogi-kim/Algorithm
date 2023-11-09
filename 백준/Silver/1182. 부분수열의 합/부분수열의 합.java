import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int ans;
    public static int n, s;
    public static boolean[] visited;
    public static int[] input;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        s = Integer.parseInt(tmp[1]);
        input = new int[n];
        visited = new boolean[n];
        tmp = bf.readLine().split(" ");
        for (int i = 0; i < tmp.length; i++) {
            input[i] = Integer.parseInt(tmp[i]);
        }

        backtracking(0, 0);
        System.out.println(ans);
    }

    public static void backtracking(int idx, int sum) {
        if (idx == n) {
            return;
        }
        if (sum + input[idx] == s) {
            ans++;
        }

        backtracking(idx + 1, sum + input[idx]);
        backtracking(idx + 1, sum);
    }
}
