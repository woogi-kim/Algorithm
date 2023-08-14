import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x, y, count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static int n;
    public static int islandNum = 2;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    numberingIsland(i, j);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] >= 2) {
                    visit = new boolean[n + 1][n + 1];
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(min);
    }

    public static void numberingIsland(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visit[x][y] = true;
        arr[x][y] = islandNum;
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                if ((1 <= nx && nx <= n) && (1 <= ny && ny <= n)) {
                    if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                        q.add(new Node(nx, ny, 0));
                        arr[nx][ny] = islandNum;
                    }
                }
            }
        }
        islandNum++;
    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visit[x][y] = true;
        int curIslandNum = arr[x][y];
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                if ((1 <= nx && nx <= n) && (1 <= ny && ny <= n)) {
                    if (arr[nx][ny] == 0 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.add(new Node(nx, ny, curNode.count + 1));
                    } else if ((arr[nx][ny] != curIslandNum) && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        min = Math.min(min, curNode.count);
                    }
                }
            }
        }
    }
    
}
