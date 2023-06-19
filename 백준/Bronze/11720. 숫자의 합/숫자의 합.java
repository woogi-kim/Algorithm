import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        String str = null;
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            str = bufferedReader.readLine();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += str.charAt(i) - 48;
            }
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}