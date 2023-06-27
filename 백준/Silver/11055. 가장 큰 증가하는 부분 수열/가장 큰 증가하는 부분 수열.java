import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] input;
    public static int[] sum;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            input = new int[n + 1];
            sum = new int[n + 1];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            for (int i = 1; i <= n; i++) {
                input[i] = Integer.parseInt(st.nextToken());
                sum[i] = input[i];
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i - 1; j++) {
                    if (input[i] > input[j]){
                        sum[i] = Math.max(sum[i], sum[j] + input[i]);
                    }
                }
            }

            int max = 0;

            for(int i : sum)
                max = Math.max(i,max);

            System.out.println(max);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}