import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class Main {
    public static String s;
    public static boolean[] visited;
    public static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();

        visited = new boolean[s.length()];
        sb = new StringBuilder();

        solve(0, s.length() - 1);
        
        System.out.println(sb.toString());
    }

    public static void solve(int start, int end) {
        if (start > end) {
            return;
        }
        int min = start;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) < s.charAt(min)) {
                min = i;
            }
        }

        visited[min] = true;

        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                sb.append(s.charAt(i));
            }
        }
        sb.append('\n');

        solve(min + 1, end);
        solve(start, min - 1);
    }
}
