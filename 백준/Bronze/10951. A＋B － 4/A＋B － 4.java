import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            while ((str = bufferedReader.readLine()) != null) {
                String[] numbers = str.split(" ");
                int a = Integer.parseInt(numbers[0]);
                int b = Integer.parseInt(numbers[1]);
                System.out.println(a+b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}