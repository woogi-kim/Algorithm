import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String[] octal = {"000", "001", "010", "011", "100", "101", "110", "111"};
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            String input = bufferedReader.readLine();
            for (int i = 0; i < input.length(); i++) {
                sb.append(octal[input.charAt(i) - '0']);
            }

            if (input.equals("0")) {
                System.out.println(input);
            } else {
                while (sb.charAt(0) == '0') {
                    sb = new StringBuilder(sb.substring(1));
                }
                System.out.println(sb);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
