import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static long ans;
    public static long[] price;
    public static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        distance = new long[n - 1];
        price = new long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int minIdx = 0;
        long distanceToNext = 0;
        for (int i = 0; i < n - 1; i++) {
            if (price[minIdx] > price[i]) {
                ans += distanceToNext * price[minIdx];
                minIdx = i;
                distanceToNext = 0;
            }
            distanceToNext += distance[i];
        }
        ans += distanceToNext * price[minIdx];
        System.out.println(ans);
    }

}
