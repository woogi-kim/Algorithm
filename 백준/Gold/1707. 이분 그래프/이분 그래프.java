import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<Integer>[] arr;
    public static int[] colors;
    public static int node, edge;
    public static int RED = 1;
    public static int BLUE = -1;
    public static boolean bipartite;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int testcase = Integer.parseInt(bufferedReader.readLine());
            while (testcase-- > 0) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                node = Integer.parseInt(st.nextToken());
                edge = Integer.parseInt(st.nextToken());

                arr = new ArrayList[node + 1];
                colors = new int[node + 1];

                for (int i = 1; i <= node; i++) {
                    arr[i] = new ArrayList<>();
                }

                for (int i = 0; i < edge; i++) {
                    st = new StringTokenizer(bufferedReader.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    arr[a].add(b);
                    arr[b].add(a);
                }

                bipartite = true;
                int ans = 0;
                for (int i = 1; i <= node; i++) {
                    if (!bipartite)
                        break;
                    if (colors[i] == 0) {
                        bfs(i, RED);
                    }
                }

                System.out.println(bipartite ? "YES" : "NO");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bfs(int startNode, int color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        colors[startNode] = color;

        while (!q.isEmpty() && bipartite) {
            int v = q.poll();
            for (int adj : arr[v]) {
                if (colors[adj] == 0) {
                    q.add(adj);
                    colors[adj] = colors[v] * -1;
                } else if (colors[v] + colors[adj] != 0) {
                    bipartite = false;
                    return;
                }
            }
        }
    }
}
