import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static long w;
    public static long leafCount;
    public static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Long.parseLong(st.nextToken());
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 2; i < n + 1; i++) {
            if (adjList[i].size() == 1) {
                leafCount++;
            }
        }
        System.out.println((double) w / leafCount);
    }
}