import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.PriorityQueue;

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    public static int v;
    public static int e;
    public static PriorityQueue<Edge> edges = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
    public static int[] parents;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);

        parents = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < e; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);

            edges.add(new Edge(start, end, weight));
        }

        for (int i = 0; i < e; i++) {
            Edge currentEdge = edges.poll();
            int startParent = find(currentEdge.start);
            int endParent = find(currentEdge.end);
            if (startParent != endParent) {
                union(currentEdge.start, currentEdge.end);
                ans += currentEdge.weight;
            }
        }
        System.out.println(ans);
    }

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return find(parents[x]);
    }

    public static void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (x > y) {
            parents[xParent] = yParent;
        } else {
            parents[yParent] = xParent;
        }
    }
}
