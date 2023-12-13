import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int blue;
    public static int white;

    public static int arr[][];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(1, 1, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void solve(int x, int y, int size) {
        if (size == 1 || isAllSameColor(x, y, size)) {
            if (arr[x][y] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }
        solve(x, y, size / 2);
        solve(x + size / 2, y, size / 2);
        solve(x, y + size / 2, size / 2);
        solve(x + size / 2, y + size / 2, size / 2);
    }

    public static boolean isAllSameColor(int x, int y, int size) {
        int firstColor = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (firstColor != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}




