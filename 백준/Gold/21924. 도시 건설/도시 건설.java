import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int m;
    public static int[][] edge;
    public static int[] parent;
    public static long min;
    public static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);


        edge = new int[m + 1][3];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            s = bf.readLine().split(" ");
            edge[i][0] = Integer.parseInt(s[0]);
            edge[i][1] = Integer.parseInt(s[1]);
            edge[i][2] = Integer.parseInt(s[2]);
            max += edge[i][2];
        }

        Arrays.sort(edge, (arr1, arr2) -> arr1[2] - arr2[2]);



        for (int i = 1; i <= m; i++) {
            if(find(edge[i][0]) != find(edge[i][1])) {
                min += edge[i][2];
                union(edge[i][0], edge[i][1]);
            }
        }

        if(isAllConnected()) {
            System.out.println(max - min);
        } else {
            System.out.println(-1);
        }

    }

    public static boolean isAllConnected() {
        int root = parent[1];
        for (int i = 2; i <= n; i++) {
            if(find(i) != root) {
                return false;
            }
        }
        return true;
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return find(parent[x]);
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