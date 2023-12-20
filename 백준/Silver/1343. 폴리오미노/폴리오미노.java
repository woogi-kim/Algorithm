import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        input = input.replaceAll("XXXX", "AAAA");
        input = input.replaceAll("XX", "BB");
        if (input.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(input);
        }
    }

}
