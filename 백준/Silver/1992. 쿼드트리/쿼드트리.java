import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int n;
    public static StringBuilder sb = new StringBuilder();

    public static void solve(int x, int y, int len) {
        int first = arr[x][y];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[x + i][y + j] != first) {
                    sb.append('(');
                    split(x, y, len / 2);
                    sb.append(')');
                    return;
                }
            }
        }
        sb.append(first);
    }

    public static void split(int x, int y, int len) {
        for (int i = x; i < x + len * 2; i += len) {
            for (int j = y; j < y + len * 2; j += len) {
                solve(i, j, len);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = bf.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        solve(0, 0, n);
        System.out.println(sb);
    }
}

