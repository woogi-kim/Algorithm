import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] arr;
    public static boolean[] visit;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[first].add(second);
            arr[second].add(first);
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            int curNode = q.poll();
            for (int adj : arr[curNode]) {
                if (visit[adj]) {
                    parent[curNode] = adj;
                } else {
                    visit[adj] = true;
                    q.add(adj);
                }
            }
        }
    }
}
