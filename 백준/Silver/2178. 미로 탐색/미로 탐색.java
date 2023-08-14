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
    public static int[][] arr;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int w, h;
    public static Queue<Node> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new int[h + 1][w + 1];
        for (int i = 1; i <= h; i++) {
            String s = bufferedReader.readLine();
            for (int j = 1; j <= w; j++) {
                arr[i][j] = (s.charAt(j - 1) - '0');
            }
        }

        bfs(1, 1);

        System.out.println(arr[h][w] - 1);
    }

    public static void bfs(int x, int y) {
        q.add(new Node(x, y));
        arr[x][y]++;
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                if ((1 <= nx && nx <= h) && (1 <= ny && ny <= w)) {
                    if (arr[nx][ny] == 1) {
                        q.add(new Node(nx, ny));
                        arr[nx][ny] = arr[curNode.x][curNode.y] + 1;
                    }
                }
            }
        }
    }
}
