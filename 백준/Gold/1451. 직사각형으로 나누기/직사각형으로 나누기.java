import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n, m;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chars[j] - '0';
            }
        }

        long ans = 0;
        // case 1
        for (int i = 0; i < n - 2; i++) {
            long a = sumRectangle(0, 0, i, m - 1);
            for (int j = i + 1; j < n - 1; j++) {
                long b = sumRectangle(i + 1, 0, j, m - 1);
                long c = sumRectangle(j + 1, 0, n - 1, m - 1);
                ans = Math.max(ans, a * b * c);
            }
        }

        // case 2
        for (int i = 0; i < m - 2; i++) {
            long a = sumRectangle(0, 0, n - 1, i);
            for (int j = i + 1; j < m - 1; j++) {
                long b = sumRectangle(0, i + 1, n - 1, j);
                long c = sumRectangle(0, j + 1, n - 1, m - 1);
                ans = Math.max(ans, a * b * c);
            }
        }

        // case 3
        for (int i = 0; i < n - 1; i++) {
            long c = sumRectangle(i + 1, 0, n - 1, m - 1);
            for (int j = 0; j < m - 1; j++) {
                long a = sumRectangle(0, 0, i, j);
                long b = sumRectangle(0, j + 1, i, m - 1);
                ans = Math.max(ans, a * b * c);
            }

        }

        // case 4
        for (int i = 0; i < n - 1; i++) {
            long c = sumRectangle(0, 0, i, m - 1);
            for (int j = 0; j < m - 1; j++) {
                long a = sumRectangle(i + 1, 0, n - 1, j);
                long b = sumRectangle(i + 1, j + 1, n - 1, m - 1);
                ans = Math.max(ans, a * b * c);
            }
        }

        // case 5
        for (int i = 0; i < m - 1; i++) {
            long c = sumRectangle(0, 0, n - 1, i);
            for (int j = 0; j < n - 1; j++) {
                long a = sumRectangle(0, i + 1, j, m - 1);
                long b = sumRectangle(j + 1, i + 1, n - 1, m - 1);
                ans = Math.max(ans, a * b * c);
            }
        }

        // case 6
        for (int i = m - 1; i >= 0; i--) {
            long c = sumRectangle(0, i, n - 1, m - 1);
            for (int j = 0; j < n - 1; j++) {
                long a = sumRectangle(0, 0, j, i - 1);
                long b = sumRectangle(j + 1, 0, n - 1, i - 1);
                ans = Math.max(ans, a * b * c);
            }
        }
        System.out.println(ans);
    }

    public static long sumRectangle(int y1, int x1, int y2, int x2) {
        long sum = 0;
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
