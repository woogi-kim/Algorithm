import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n;
    public static int[] distance;
    public static int totalSum;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        distance = new int[2 * n];

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            distance[i] = Integer.parseInt(s);
            distance[i + n] = Integer.parseInt(s);
        }

        for (int i = 0; i < n; i++) {
            totalSum += distance[i];
        }

        int start = 0;
        int end = 1;
        int currentSum1 = distance[start];
        int currentSum2 = totalSum - currentSum1;

        while (start < n) {
            ans = Math.max(ans, Math.min(currentSum1, currentSum2));
            
            if(currentSum1 > currentSum2) {
                currentSum1 -= distance[start];
                currentSum2 += distance[start];
                start++;
            } else {
                currentSum1 += distance[end];
                currentSum2 -= distance[end];
                end++;
            }
        }

        System.out.println(ans);
    }

}
