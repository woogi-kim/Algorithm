import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] input = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int min = Math.min(a, b);
            int max = Math.max(a, b);
            int gcd = 1;
            for (int i = 1; i <= min; i++) {
                if (a % i == 0 && b % i == 0)
                    gcd = i;
            }

            int lcm = max;
            while (lcm % min != 0) {
                lcm += max;
            }

            System.out.println(gcd);
            System.out.println(lcm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
