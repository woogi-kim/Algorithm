import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.valueOf(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                String str = bufferedReader.readLine();
                String[] numbers = str.split(" ");
                int a = Integer.valueOf(numbers[0]);
                int b = Integer.valueOf(numbers[1]);
                bufferedWriter.write(String.valueOf(a + b) + "\n");
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}