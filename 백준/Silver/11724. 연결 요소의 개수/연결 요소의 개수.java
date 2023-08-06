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
    public static int node, edge;
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());

            arr = new int[node + 1][node + 1];
            check = new boolean[node + 1];
            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(bufferedReader.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = arr[b][a] = 1;
            }

            int ans = 0;
            for (int i = 1; i <= node ; i++) {
                if(check[i])
                    continue;
                bfs(i);
                ans++;
            }

            System.out.println(ans);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bfs(int startNode) {
        q.add(startNode);
        check[startNode] = true;

        while (!q.isEmpty()) {
            startNode = q.poll();
            for (int i = 1; i <= node; i++) {
                if (arr[startNode][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
