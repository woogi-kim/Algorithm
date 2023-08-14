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
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h + 1][w + 1];
        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (arr[i][j] == 1) {
                    q.add(new Node(i, j));
                }
            }
        }

        bfs();

        int max = 0;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else {
                    if (arr[i][j] > max)
                        max = arr[i][j];
                }
            }
        }
        System.out.println(max - 1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                if ((1 <= nx && nx <= h) && (1 <= ny && ny <= w)) {
                    if (arr[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                        arr[nx][ny] = arr[curNode.x][curNode.y] + 1;
                    }
                }
            }
        }
    }
}