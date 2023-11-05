import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int F, S, G, U, D;
    public static int ans;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F + 1];
        bfs();
        System.out.println(ans == -1 ? "use the stairs" : ans);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = 1;
        while (!q.isEmpty()) {
            Integer current = q.remove();
            if (current == G) {
                ans = visited[G] - 1;
                return;
            }
            for (int i = 0; i < 2; i++) {
                int next = current;
                if (i == 0) {
                    next += U;
                } else {
                    next -= D;
                }
                if (next >= 1 && next <= F) {
                    if (visited[next] == 0) {
                        visited[next] = visited[current] + 1;
                        q.add(next);
                    }
                }
            }

        }
        ans = -1;
    }
}
