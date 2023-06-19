import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        String str = null;
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 1; i <= 9; i++) {
                System.out.println(n + " * " + i + " = " + n * i);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}