import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                String[] input = bufferedReader.readLine().split(" ");
                int m = Integer.parseInt(input[0]);

                int[] num = new int[m];
                for (int j = 0; j < m; j++) {
                    num[j] = Integer.parseInt(input[j + 1]);
                }
                
                long sum = 0;
                for (int j = 0; j < m - 1; j++) {
                    for (int k = j + 1; k < m; k++) {
                        sum += gcd(num[j], num[k]);
                    }
                }
                sb.append(sum).append('\n');
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
