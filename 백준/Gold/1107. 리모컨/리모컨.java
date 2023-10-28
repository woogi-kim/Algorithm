import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int chanel;
    public static int brokenCount;
    public static boolean[] isBroken = new boolean[10];

    public static boolean containBroken(int i) {
        String s = String.valueOf(i);
        int len = s.length();
        for (int j = 0; j < len; j++) {
            if (isBroken[s.charAt(j) - '0']) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        chanel = Integer.parseInt(bf.readLine());
        brokenCount = Integer.parseInt(bf.readLine());
        if (brokenCount > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(chanel - 100);

        for (int i = 0; i <= 999999; i++) {
            if (!containBroken(i)) {
                int tmp = Math.abs(chanel - i) + String.valueOf(i).length();
                ans = Math.min(ans, tmp);
            }
        }
        System.out.println(ans);
    }
}
