import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static int n;
    public static int m;
    //    public static int[][] edge;
    public static PriorityQueue<int[]> edge = new PriorityQueue<>((a, b) -> {
        return a[2] - b[2];
    });
    public static int[] parent;
    public static int cnt;
    public static long min;
    public static long max;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);


//        edge = new int[m + 1][3];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            edge.add(new int[]{start, end, weight});
            max += weight;
        }

        for (int i = 1; i <= m; i++) {
            int[] current = edge.poll();
            int parentA = find(current[0]);
            int parentB = find(current[1]);

            if (parentA != parentB) {
                min += current[2];
                union(parentA, parentB);
                cnt++;
            }
        }

        if (cnt == n - 1) {
            System.out.println(max - min);
        } else {
            System.out.println(-1);
        }

    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
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