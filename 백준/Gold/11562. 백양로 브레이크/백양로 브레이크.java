import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int v;
    boolean isConnected;
}

public class Main {
    public static int n, m, k;
    public static int[][] dist;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 65000);
        }

        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);

            dist[u][v] = 0;
            dist[v][u] = (b == 0) ? 1 : 0;
        }

        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }

        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][l] + dist[l][j]);
                }
            }
        }

        k = Integer.parseInt(bf.readLine());

        for (int i = 0; i < k; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            sb.append(dist[start][end]).append('\n');
        }

        System.out.println(sb.toString());
    }


}