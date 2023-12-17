import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int r;
    public static int c;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve(r, c, (int) Math.pow(2, n));
        System.out.println(cnt);
    }

    public static void solve(int x, int y, int size) {
        if (size == 1) {
            return;
        }
        if (x < size / 2 && y < size / 2) {
            solve(x, y, size / 2);
        }
        else if (x < size / 2 && size / 2 <= y) {
            cnt += (size / 2) * (size / 2);
            solve(x, y - size / 2, size / 2);
        }
        else if (size / 2 <= x && y < size / 2) {
            cnt += 2 * (size / 2) * (size / 2);
            solve(x - size / 2, y, size / 2);
        }
        else {
            cnt += 3 * (size / 2) * (size / 2);
            solve(x - size / 2, y - size / 2, size / 2);
        }
    }
}
