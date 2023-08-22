import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start).append(" ").append(to).append('\n');
            return;
        }
        hanoi(n - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append('\n');
        hanoi(n - 1, mid, start, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        hanoi(n, 1, 2, 3);
        System.out.println((int) Math.pow(2, n) - 1);
        System.out.println(sb);
    }
}

