import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Position {
    int pos;
    int second;

    public Position(int pos, int second) {
        this.pos = pos;
        this.second = second;
    }
}

public class Main {
    public static int n, k;
    public static int ans = Integer.MAX_VALUE;
    public static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        bfs(new Position(n, 0));
        System.out.println(ans);

    }

    public static void bfs(Position position) {
        Queue<Position> q = new LinkedList<>();
        q.add(position);
        while (!q.isEmpty()) {
            Position current = q.remove();
            if (current.pos == k) {
                ans = current.second;
                return;
            }
            if (current.pos >= 0 && current.pos <= 100000) {
                if (!visit[current.pos]) {
                    visit[current.pos] = true;
                    q.add(new Position(current.pos - 1, current.second + 1));
                    q.add(new Position(current.pos + 1, current.second + 1));
                    q.add(new Position(current.pos * 2, current.second + 1));
                }
            }
        }
    }
}
