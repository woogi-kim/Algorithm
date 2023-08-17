import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int value;
    long distance;

    public Node(int value, long distance) {
        this.value = value;
        this.distance = distance;
    }
}

public class Main {
    public static int n;
    public static ArrayList<Node>[] arr;
    public static boolean[] visit;
    public static long max = 0;
    public static int maxIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int adj = Integer.parseInt(st.nextToken());
                if (adj == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                arr[node].add(new Node(adj, distance));
            }
        }

        visit = new boolean[n + 1];
        int idx1 = bfs(1);

        visit = new boolean[n + 1];
        bfs(idx1);
        System.out.println(max);
    }


    public static int bfs(int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, 0));
        visit[x] = true;
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (Node node : arr[curNode.value]) {
                if (!visit[node.value]) {
                    long distance = curNode.distance + node.distance;
                    if (distance > max) {
                        maxIdx = node.value;
                        max = distance;
                    }
                    q.add(new Node(node.value, distance));
                    visit[node.value] = true;
                }
            }
        }
        return maxIdx;
    }
}
