import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int n;
    public static int[] ans = new int[3];

    public static void split(int x, int y, int len) {
        for (int i = x; i < x + len * 3; i += len) {
            for (int j = y; j < y + len * 3; j += len) {
                count(i, j, len);
            }
        }
    }

    public static void count(int x, int y, int len) {
        int first = arr[x][y];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[x + i][y + j] != first) {
                    split(x, y, len / 3);
                    return;
                }
            }
        }
        ans[first + 1]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count(0, 0, n);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
    }
}