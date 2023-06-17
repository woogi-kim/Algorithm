import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int a = Integer.valueOf(bufferedReader.readLine());
            int b = Integer.valueOf(bufferedReader.readLine());
            bufferedWriter.write(String.valueOf(a+b));
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}