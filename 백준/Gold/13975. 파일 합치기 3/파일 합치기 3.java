
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int t;
    public static int k;
    public static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            PriorityQueue<Long> pq = new PriorityQueue<Long>();
            k = Integer.parseInt(bf.readLine());
            arr = new int[k];

            String[] s = bf.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                long tmp = Integer.parseInt(s[i]);
                pq.add(tmp);
            }
            long sum = 0;
            for (int i = 0; i < k - 1; i++) {
                long a = pq.poll();
                long b = pq.poll();
                pq.add(a + b);
                sum += a + b;
            }
            sb.append(sum).append('\n');

        }
        System.out.println(sb);
    }

}



