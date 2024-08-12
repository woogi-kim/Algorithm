import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static String s;
    public static String t;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();
        t = bf.readLine();

        int loop = t.length() - s.length();

        StringBuilder sb = new StringBuilder(t);
        for (int i = 0; i < loop; i++) {
            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.reverse();
            }
        }

        System.out.println(sb.toString().equals(s) ? 1 : 0);
    }

}