
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int idx;
    int cnt;

    public Node(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}

public class Main {
    public static int ans;
    public static int n;
    public static int m;
    public static boolean[] visited;
    public static HashMap<Integer, Integer> laddersAndSnakes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        visited = new boolean[101];


        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        laddersAndSnakes = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            laddersAndSnakes.put(start, end);
        }

        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            laddersAndSnakes.put(start, end);
        }

        solve();

        System.out.println(ans);
    }

    public static void solve() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        visited[1] = true;
        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.idx == 100) {
                ans = current.cnt;
                break;
            } else {
                for (int i = 1; i <= 6; i++) {
                    int next = current.idx + i;
                    if (next > 100) {
                        continue;
                    }
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;

                    if (laddersAndSnakes.containsKey(next)) {
                        int newNext = laddersAndSnakes.get(next);
                        if (!visited[newNext]) {
                            q.add(new Node(newNext, current.cnt + 1));
                            visited[newNext] = true;
                        }
                    } else {
                        q.add(new Node(next, current.cnt + 1));
                    }

                }
            }
        }
    }

}




