import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long countFive(long n) {
        long cnt = 0;
        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    public static long countTwo(long n) {
        long cnt = 0;
        while (n >= 2) {
            cnt += n / 2;
            n /= 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine()," ");
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long two = countTwo(n) - countTwo(n - m) - countTwo(m);
            long five = countFive(n) - countFive(n - m) - countFive(m);

            System.out.println(Math.min(two, five));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
