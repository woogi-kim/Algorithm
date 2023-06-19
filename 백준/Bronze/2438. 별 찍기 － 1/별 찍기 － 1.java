import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    bufferedWriter.write("*");
                }
                bufferedWriter.flush();
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
