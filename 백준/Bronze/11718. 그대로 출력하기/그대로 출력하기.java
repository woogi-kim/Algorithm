import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = null;
        try {
            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str + "\n");
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}