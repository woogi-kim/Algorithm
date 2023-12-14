import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int input[][];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        input = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(input, n);
    }

    public static void solve(int[][] arr, int size) {
        if (size == 1) {
            System.out.println(arr[1][1]);
            return;
        }
        int[][] newArr = new int[size / 2 + 1][size / 2 + 1];

        for (int i = 1; i <= size / 2; i++) {
            for (int j = 1; j <= size / 2; j++) {
                int x = 2 * i - 1;
                int y = 2 * j - 1;
                int[] tmp = {arr[x][y], arr[x][y + 1], arr[x + 1][y], arr[x + 1][y + 1]};
                Arrays.sort(tmp);
                newArr[i][j] = tmp[2];
            }
        }
        solve(newArr, size / 2);
    }

}




