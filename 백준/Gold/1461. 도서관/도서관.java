import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        PriorityQueue<Integer> plus = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minus = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(s[i]);

            if (tmp > 0) {
                plus.add(tmp);
            } else {
                minus.add(Math.abs(tmp));
            }
        }

        int ans = 0;
        int max = 0;

        if (plus.isEmpty()) {
            max = minus.peek();
        } else if (minus.isEmpty()) {
            max = plus.peek();
        } else {
            max = Math.max(minus.peek(), plus.peek());
        }

        while (!plus.isEmpty()) {
            int farBook = plus.poll();

            for (int i = 0; i < m - 1; i++) {
                plus.poll();

                if (plus.isEmpty()) {
                    break;
                }
            }

            ans += (2 * farBook);
        }

        while (!minus.isEmpty()) {
            int farBook = minus.poll();

            for (int i = 0; i < m - 1; i++) {
                minus.poll();

                if (minus.isEmpty()) {
                    break;
                }
            }

            ans += (2 * farBook);
        }

        ans -= max;

        System.out.println(ans);
    }

}