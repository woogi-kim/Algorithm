import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n;
    public static int m;
    public static int r;
    public static int[][] arr;
    public static int cycleCount;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);
        cycleCount = Math.min(n, m) / 2;

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < cycleCount; i++) {
            List<Integer> tmp = new ArrayList<>();

            for (int j = i; j < m - i; j++) {
                tmp.add(arr[i][j]);
            }

            for (int j = i + 1; j < n - i; j++) {
                tmp.add(arr[j][m - i - 1]);
            }

            for (int j = m - i - 2; j >= i; j--) {
                tmp.add(arr[n - i - 1][j]);
            }

            for (int j = n - i - 2; j >= i + 1; j--) {
                tmp.add(arr[j][i]);
            }

            int len = tmp.size();
            int currentR = r % len;

            int j = 0;
            for (int k = i; k < m - i; k++) {
                arr[i][k] = tmp.get(j + currentR >= len ? (j + currentR) % len : j + currentR);
                j++;
            }

            for (int k = i + 1; k < n - i; k++) {
                arr[k][m - i - 1] = tmp.get(j + currentR >= len ? (j + currentR) % len : j + currentR);
                j++;
            }

            for (int k = m - i - 2; k >= i; k--) {
                arr[n - i - 1][k] = tmp.get(j + currentR >= len ? (j + currentR) % len : j + currentR);
                j++;
            }

            for (int k = n - i - 2; k >= i + 1; k--) {
                arr[k][i] = tmp.get(j + currentR >= len ? (j + currentR) % len : j + currentR);
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


}