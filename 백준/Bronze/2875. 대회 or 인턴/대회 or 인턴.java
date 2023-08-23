import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 0; i <= k; i++) {
            int x = n - i;
            int y = m - (k - i);
            if(x <= 0 || y <= 0){
                continue;
            }

            if (x / 2 <= y) {
                ans = Math.max(ans, x / 2);
            } else {
                ans = Math.max(ans, y);
            }
        }
        System.out.println(ans);
    }
}

