import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int count[] = new int[26];

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            String input = bufferedReader.readLine();

            for (int i = 0; i < input.length(); i++) {
                count[input.charAt(i) - 'a']++;
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