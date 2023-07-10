import java.io.*;
import java.util.*;

public class Main {
    public static int[] input;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(bufferedReader.readLine());
            }

            Arrays.sort(input);

            for(int i : input){
                sb.append(i);
                sb.append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}