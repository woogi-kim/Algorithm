import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            String[] input = bufferedReader.readLine().split(" ");
            String ori = input[0];
            long base = Integer.parseInt(input[1]);

            long decimal = 0;
            long mul = 1;
            for (int i = ori.length() - 1; i >= 0; i--) {
                char c = ori.charAt(i);
                if ('A' <= c && c <= 'Z') {
                    decimal += mul * (10 + c - 'A');
                } else {
                    decimal += mul * (c - '0');
                }
                mul *= base;
            }
            System.out.println(decimal);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
