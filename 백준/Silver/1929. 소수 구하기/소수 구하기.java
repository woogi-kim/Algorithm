import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            String[] input = bufferedReader.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            int[] arr = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                arr[i] = i;
            }

            for (int i = 2; i <= n; i++) {
                if (arr[i] == 0)
                    continue;
                for (int j = i + i; j <= n; j += i) {
                    arr[j] = 0;
                }
            }

            for (int i = m; i <= n; i++) {
                if (arr[i] != 0) sb.append(arr[i]).append("\n");
            }

            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
