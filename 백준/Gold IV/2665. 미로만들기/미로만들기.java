import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static int[][] arr;
    public static int[][] breaks;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        arr = new int[n][n];
        breaks = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(breaks[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        bfs();

        System.out.println(breaks[n - 1][n - 1]);
    }


    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0));
        breaks[0][0] = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    if (breaks[newX][newY] > breaks[current.x][current.y]) {
                        if (arr[newX][newY] == 0) {
                            breaks[newX][newY] = breaks[current.x][current.y] + 1;
                        } else {
                            breaks[newX][newY] = breaks[current.x][current.y];
                        }
                        q.add(new Node(newX, newY));
                    }
                }
            }
        }

    }
}




