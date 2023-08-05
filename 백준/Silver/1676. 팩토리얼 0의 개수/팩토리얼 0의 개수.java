import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                int num = i;
                while (num % 5 == 0) {
                    cnt++;
                    num /= 5;
                }
            }
            System.out.println(cnt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
