import java.io.*;
import java.util.*;

public class Main {
    public static int[] input;
    public static int N;
    public static int K;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        try {
            String[] s1 = bufferedReader.readLine().split(" ");
            N = Integer.parseInt(s1[0]);
            K = Integer.parseInt(s1[1]);

            input = new int[N];

            String[] s2 = bufferedReader.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(s2[i]);
            }

            Arrays.sort(input);
            System.out.println(input[K - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}