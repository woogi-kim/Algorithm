import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] input = bufferedReader.readLine().split(" ");

            int count = 0;
            for (String s : input) {
                if (isPrime(Integer.parseInt(s)))
                    count++;
            }

            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
