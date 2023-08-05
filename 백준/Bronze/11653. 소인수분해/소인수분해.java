import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            int i = 2;
            while (n != 1) {
                if (n % i == 0) {
                    n /= i;
                    sb.append(i).append("\n");
                } else {
                    i++;
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
