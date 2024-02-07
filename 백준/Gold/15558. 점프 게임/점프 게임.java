import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;
    int time;

    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    public static int ans;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        arr = new int[2][n];
        visited = new boolean[2][n];
        for (int i = 0; i < 2; i++) {
            String tmp = bf.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }

        solve();
        System.out.println(ans);
    }

    public static void solve() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.y >= n) {
                ans = 1;
                break;
            } else {
                if (current.y < 0) {
                    continue;
                }
                if (visited[current.x][current.y]) {
                    continue;
                }
                if (arr[current.x][current.y] == 0) {
                    continue;
                }
                if (current.y < current.time && current.time > 0) {
                    continue;
                }
                visited[current.x][current.y] = true;

                for (int i = 0; i < 3; i++) {
                    int nextX = current.x;
                    int nextY = current.y;
                    switch (i) {
                        case 0:
                            nextY++;
                            break;
                        case 1:
                            nextY--;
                            break;
                        case 2:
                            nextX = (nextX == 1) ? 0 : 1;
                            nextY += k;
                            break;
                    }
                    q.add(new Node(nextX, nextY, current.time + 1));
                }
            }
        }

    }
}




