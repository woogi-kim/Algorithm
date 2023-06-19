import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n + i; j++) {
                    if (j == n - i - 1 || j == n + i - 1) {
                        bufferedWriter.write("*");
                    } else {
                        bufferedWriter.write(" ");
                    }
                }
                bufferedWriter.newLine();
            }
            for (int i = 0; i < 2 * n - 1; i++) {
                bufferedWriter.write("*");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}