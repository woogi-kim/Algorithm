import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(bufferedReader.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            arr = new ArrayList[n + 1];
            visit = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 1; i <= n; i++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    dfs(i);
                    ans++;
                }
            }
            System.out.println(ans);
        }

    }

    public static void dfs(int startNode) {
        visit[startNode] = true;
        for (int adj : arr[startNode]) {
            if (!visit[adj]) {
                visit[adj] = true;
                dfs(adj);
            }
        }
    }
}