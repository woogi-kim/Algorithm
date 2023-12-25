import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st1 = new StringTokenizer(s, "-");
        while (st1.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
            int tmp = 0;
            while (st2.hasMoreTokens()) {
                tmp += Integer.parseInt(st2.nextToken());
            }
            if (ans == Integer.MAX_VALUE) {
                ans = tmp;
            } else {
                ans -= tmp;
            }
        }


        System.out.println(ans);
    }

}