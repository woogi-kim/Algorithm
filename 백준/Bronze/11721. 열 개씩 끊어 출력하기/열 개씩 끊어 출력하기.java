import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = null;
        try {
            str = bufferedReader.readLine();
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
                if (i % 10 == 9){
                    System.out.println();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
