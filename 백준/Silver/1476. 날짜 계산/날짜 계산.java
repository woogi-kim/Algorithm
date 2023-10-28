import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int e, s, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int ans = 1;
        int eCount = 1;
        int sCount = 1;
        int mCount = 1;
        while (true) {
            if (e == eCount && s == sCount && m == mCount) {
                break;
            }
            eCount = eCount >= 15 ? 1 : eCount + 1;
            sCount = sCount >= 28 ? 1 : sCount + 1;
            mCount = mCount >= 19 ? 1 : mCount + 1;
            ans++;
        }
        System.out.println(ans);
    }
}

