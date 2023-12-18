import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = bf.readLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            n = Integer.parseInt(input);
            sb = new StringBuilder();
            solve(n);
            System.out.println(sb);
        }
    }

    public static void solve(int n) {
        if (n == 0) {
            sb.append('-');
            return;
        }
        solve(n - 1);
        int iter = (int) Math.pow(3, n - 1);
        for (int i = 0; i < iter; i++) {
            sb.append(' ');
        }
        solve(n - 1);
    }
}
