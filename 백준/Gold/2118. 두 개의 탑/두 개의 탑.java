import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n;
    public static int[] distance;
    public static int totalSum;
    public static int[] distanceSums;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        distance = new int[2 * n];
        distanceSums = new int[2 * n];


        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            distance[i] = Integer.parseInt(s);
            distance[i + n] = Integer.parseInt(s);
        }

        for (int i = 0; i < n; i++) {
            totalSum += distance[i];
        }

        distanceSums[0] = distance[0];
        for (int i = 1; i < 2 * n; i++) {
            distanceSums[i] = distance[i] + distanceSums[i - 1];
        }

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int currentSum = distanceSums[j + i - 1];
                if (j != 0) {
                    currentSum -= distanceSums[j - 1];
                }

                int path1 = currentSum;
                int path2 = totalSum - currentSum;

                int currentPathDistance = Math.min(path1, path2);
                ans = Math.max(ans, currentPathDistance);
            }
        }

        System.out.println(ans);


    }

}
