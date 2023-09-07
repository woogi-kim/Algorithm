import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int max = 1;

//    public static void solve(int x, int y, int count) {
//        if ((x > n || x < 1) || (y > m || y < 1)) {
//            max = Math.max(count, max);
//            return;
//        }
//        if (arr[x][y] != 0) {
//            arr[x][y] = Math.max(count, arr[x][y]);
//            return;
//        }
//        arr[x][y] = count;
//        solve(x - 2, y + 1, count + 1);
//        solve(x - 1, y + 2, count + 1);
//        solve(x + 2, y + 1, count + 1);
//        solve(x + 1, y + 2, count + 1);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == 1) {
            max = 1;
        } else if (n == 2) {
            max = Math.min((m + 1) / 2, 4);
        } else if (n >= 3) {
            if (m < 7) {
                max = Math.min(m, 4);
            } else {
                max = m - 2;
            }
        }
        System.out.println(max);
    }
}

