import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int ans;
    public static boolean[] visit;
    public static boolean[] finish;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(bufferedReader.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

            arr = new int[n + 1];
            visit = new boolean[n + 1];
            finish = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            for (int i = 1; i <= n; i++) {
                if(!visit[i])
                    dfs(i);
            }
            System.out.println(n - ans);
        }
    }

    public static void dfs(int n) {
        visit[n] = true;
        int next = arr[n];

        if (!visit[next]) {
            dfs(next);
        } else {
            if (!finish[next]) {
                for (int i = next; i != n; i = arr[i]) {
                    ans++;
                }
                ans++;
            }
        }
        finish[n] = true;
    }

}
