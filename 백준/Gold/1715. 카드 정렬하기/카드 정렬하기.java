import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n;
    public static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(bf.readLine()));
        }

        for (int i = 0; i < n - 1; i++) {
            long a = pq.poll();
            long b = pq.poll();

            long compare = a + b;
            ans += compare;
            pq.add(compare);
        }
        
        System.out.println(ans);
    }


}