import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int count[] = new int[26];

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            String input = bufferedReader.readLine();

            for (int i = 0; i < 26; i++) {
                count[i] = input.indexOf('a' + i);
            }

            for (int i : count) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}