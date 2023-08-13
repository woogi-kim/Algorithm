import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static char[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int N;
    public static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(bufferedReader.readLine());
        arr = new char[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String s = bufferedReader.readLine();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = s.charAt(j - 1);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visit[i][j] && arr[i][j] == '1') {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(ans);

        sb.append(ans.size()).append('\n');
        for (int n : ans) {
            sb.append(n).append('\n');
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        visit[x][y] = true;
        int count = 1;
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                if ((1 <= nx && nx <= N) && (1 <= ny && ny <= N)) {
                    if (!visit[nx][ny] && arr[nx][ny] == '1') {
                        q.add(new Node(nx, ny));
                        visit[nx][ny] = true;
                        count++;
                    }
                }
            }
        }
        ans.add(count);
    }
}
