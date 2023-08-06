import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] arr;
    public static boolean[] check;
    public static int node, edge, startNode;
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            startNode = Integer.parseInt(st.nextToken());

            arr = new int[node + 1][node + 1];
            check = new boolean[node + 1];
            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = 1;
            }

            dfs(startNode);
            sb.append("\n");
            check = new boolean[node + 1];
            bfs(startNode);

            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dfs(int startNode) {
        check[startNode] = true;
        sb.append(startNode).append(" ");
        for (int i = 1; i <= node; i++) {
            if (arr[startNode][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int startNode) {
        q.add(startNode);
        check[startNode] = true;

        while (!q.isEmpty()) {
            startNode = q.poll();
            sb.append(startNode).append(" ");
            for (int i = 1; i <= node; i++) {
                if (arr[startNode][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
