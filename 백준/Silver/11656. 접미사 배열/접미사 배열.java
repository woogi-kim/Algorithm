import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static String[] suffix;
    public static int n;
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = bufferedReader.readLine();
            n = input.length();
            suffix = new String[n];
            for (int i = 0; i < n; i++) {
                suffix[i] = input.substring(i,n);
            }

            Arrays.sort(suffix);

            for(String s :suffix)
                System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
