import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int count[] = new int[26];

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                int upper = 0, lower = 0, number = 0, space = 0;
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if ('a' <= c && c <= 'z')
                        lower++;
                    else if ('A' <= c && c <= 'Z')
                        upper++;
                    else if ('0' <= c && c <= '9')
                        number++;
                    else if (c == ' ')
                        space++;
                }
                sb.append(lower).append(' ').append(upper).append(' ').append(number).append(' ').append(space);
                System.out.println(sb);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}