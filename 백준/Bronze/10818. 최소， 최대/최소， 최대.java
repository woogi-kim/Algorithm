import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] numbers = bufferedReader.readLine().split(" ");
            int min = 1000001;
            int max = -1000001;
            for (int i = 0; i < numbers.length; i++) {
                int num = Integer.parseInt(numbers[i]);
                if (num > max)
                    max = num;
                if (num < min)
                    min = num;
            }
            System.out.println(min + " " + max);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}