import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int k;
    public static boolean[] visited;
    public static int[] input;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = bf.readLine().split(" ");
            if (s[0].equals("0")) {
                break;
            }
            k = Integer.parseInt(s[0]);
            visited = new boolean[k];
            input = new int[k];

            for (int i = 0; i < k; i++) {
                input[i] = Integer.parseInt(s[i + 1]);
            }
            for (int i = 0; i < k; i++) {
                visited[i] = true;
                backtracking(0, i);
                visited[i] = false;
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void backtracking(int depth, int currentIdx) {
        if (depth == 5) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    sb.append(input[i]).append(" ");
                }
            }
            sb.append('\n');
        }

        for (int i = currentIdx + 1; i < k; i++) {
            visited[i] = true;
            backtracking(depth + 1, i);
            visited[i] = false;

        }
    }
}
