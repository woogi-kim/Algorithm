import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            String[] input = bufferedReader.readLine().split(" ");
            long a = Long.parseLong(input[0]);
            int b = Integer.parseInt(input[1]);
            while (a > 0) {
                if (a % b > 9) {
                    sb.append((char) ('A' + ((a % b) - 10)));
                } else {
                    sb.append(a % b);
                }
                a /= b;
            }
            System.out.println(sb.reverse());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
