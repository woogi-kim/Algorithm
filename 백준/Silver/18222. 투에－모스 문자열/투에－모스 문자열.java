import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long n;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Long.parseLong(st.nextToken());
        n--;
        int count = 0;
        while (n > 1) {
            long square = 2;
            while (true) {
                if (square * 2 > n) {
                    break;
                }
                square *= 2;
            }
            count++;
            n -= square;
        }

        System.out.println((count % 2 == 0) ? n : ((n == 0) ? 1 : 0));
    }
}
