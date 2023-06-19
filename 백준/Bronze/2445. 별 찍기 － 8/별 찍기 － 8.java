import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    if (i < j && j < 2 * n - i - 1) {
//                        if (Math.abs(2 * n - 2 - i) < j && j < 2 * n - Math.abs(2 * n - 2 - i) - 1) {
                        bufferedWriter.write(" ");
                    } else {
                        bufferedWriter.write("*");
                    }
                }
                bufferedWriter.newLine();
            }
            for (int i = n; i < 2 * n - 1; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    if (Math.abs(2 * n - 2 - i) < j && j < 2 * n - Math.abs(2 * n - 2 - i) - 1) {
                        bufferedWriter.write(" ");
                    } else {
                        bufferedWriter.write("*");
                    }
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
