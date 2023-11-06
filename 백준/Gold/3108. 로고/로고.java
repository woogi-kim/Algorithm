import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Rec {
    int x1;
    int y1;
    int x2;
    int y2;

    public Rec(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class Main {
    public static int n;
    public static int ans;
    public static boolean[] visited;
    public static Rec[] rec;
    public static int x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        visited = new boolean[n + 1];
        rec = new Rec[n + 1];

        rec[0] = new Rec(0, 0, 0, 0);
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            rec[i] = new Rec(x1, y1, x2, y2);
        }

        for (int i = 0; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                ans++;
            }
        }

        System.out.println(ans-1);
    }

    public static void bfs(int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited[k] = true;
        while (!q.isEmpty()) {
            Integer current = q.remove();
            for (int i = 0; i <= n; i++) {
                if (current == i || !isContained(current, i) || visited[i]) {
                    continue;
                }
                q.add(i);
                visited[i] = true;

            }
        }
    }

    public static boolean isContained(int current, int next) {
        Rec c = rec[current];
        Rec n = rec[next];
        if ((c.x1 < n.x1 && n.x2 < c.x2 && c.y1 < n.y1 && n.y2 < c.y2)
                || (c.x1 > n.x1 && n.x2 > c.x2 && c.y1 > n.y1 && n.y2 > c.y2)
                || c.x2 < n.x1 || c.x1 > n.x2 || c.y2 < n.y1 || c.y1 > n.y2) {
            return false;
        }
        return true;
    }

}

