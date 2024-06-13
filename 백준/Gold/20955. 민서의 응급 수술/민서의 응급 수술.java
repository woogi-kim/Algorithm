import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static int n;
    public static int m;
    public static int[] parent;
    public static int cycleCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            int r1 = find(a);
            int r2 = find(b);

            if (r1 != r2) {
                union(r1, r2);
            } else {
                cycleCount++;
            }
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            hashSet.add(find(i));
        }

        System.out.println(hashSet.size() + cycleCount - 1);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}