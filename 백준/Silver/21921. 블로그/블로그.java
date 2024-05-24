import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int n;
    public static int x;
    public static int[] visitSum;
    public static int maxVisit;
    public static int maxVisitDuration;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        x = Integer.parseInt(s[1]);

        visitSum = new int[n + 1];

        s = bf.readLine().split(" ");

        visitSum[1] = Integer.parseInt(s[0]);
        for (int i = 2; i < n + 1; i++) {
            visitSum[i] = visitSum[i - 1] + Integer.parseInt(s[i - 1]);
        }

        for (int i = x; i < n + 1; i++) {
            int currentSum = visitSum[i] - visitSum[i - x];
            if (currentSum > maxVisit) {
                maxVisit = currentSum;
                maxVisitDuration = 1;
            } else if (currentSum == maxVisit) {
                maxVisitDuration++;
            }
        }

        System.out.println(maxVisit == 0 ? "SAD" : (maxVisit + "\n" + maxVisitDuration));

    }

}