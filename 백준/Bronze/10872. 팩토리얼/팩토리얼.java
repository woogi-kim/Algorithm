import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long solve(long n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * solve(n - 1);
        }
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            long n = Long.parseLong(bufferedReader.readLine());
            System.out.println(solve(n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
