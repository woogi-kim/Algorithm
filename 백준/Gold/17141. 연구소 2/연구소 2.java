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
    public static int m;
    public static int[][] arr;
    public static int[][] isVisited;
    public static boolean[] isIncluded;
    public static ArrayList<Node> virusPos;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static boolean canSpread;
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][n];
        isVisited = new int[n][n];
        virusPos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                if (arr[i][j] == 2) {
                    virusPos.add(new Node(i, j));
                }
            }
        }

        isIncluded = new boolean[virusPos.size()];

        combination(0, m, 0);

        System.out.println(canSpread ? ans - 1 : -1);
    }

    public static void combination(int depth, int target, int start) {
        if (depth == target) {
            bfs();
        } else {
            for (int i = start; i < virusPos.size(); i++) {
                isIncluded[i] = true;
                combination(depth + 1, target, i + 1);
                isIncluded[i] = false;
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        isVisited = new int[n][n];
        int currentSearchTime = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    isVisited[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < isIncluded.length; i++) {
            if (isIncluded[i]) {
                q.add(virusPos.get(i));
                isVisited[virusPos.get(i).x][virusPos.get(i).y] = 1;
            }
        }

        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    if (isVisited[newX][newY] == 0) {
                        isVisited[newX][newY] = isVisited[current.x][current.y] + 1;
                        q.add(new Node(newX, newY));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j] == 0) {
                    return;
                } else if (isVisited[i][j] >= 1) {
                    currentSearchTime = Math.max(isVisited[i][j], currentSearchTime);
                }
            }
        }
 
        canSpread = true;
        ans = Math.min(ans, currentSearchTime);
    }
}




