import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

class Node {
    long num;
    int depth;

    public Node(long num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}

public class Main {
    public static int a;
    public static int b;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        bfs(a);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void bfs(int a) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, 1));
        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.num == b) {
                ans = Math.min(current.depth, ans);
            }
            if (current.num * 2 <= b) {
                q.add(new Node(current.num * 2, current.depth + 1));
            }
            if (current.num * 10 + 1 <= b) {
                q.add(new Node(current.num * 10 + 1, current.depth + 1));
            }
        }
    }

}