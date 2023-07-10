import java.io.*;
import java.util.*;

public class Main {
    public static long[] input;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            input = new long[n];
            for (int i = 0; i < n; i++) {
                input[i] = Long.parseLong(bufferedReader.readLine());
            }
            
            int maxCount = 0;
            long x = 0;
            Map<Long, Integer> count = new HashMap<>();
            
            for (long i : input) {
                if (count.containsKey(i)) {
                    count.put(i, count.get(i) + 1);
                } else {
                    count.put(i, 1);
                }
                
                if (count.get(i) > maxCount) {
                    maxCount = count.get(i);
                    x = i;
                } else if (count.get(i) == maxCount)
                    x = Math.min(x, i);
            }

            System.out.println(x);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}