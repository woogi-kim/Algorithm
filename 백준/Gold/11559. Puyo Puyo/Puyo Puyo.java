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
    public static boolean isContinue;
    public static boolean[][] visited;
    public static boolean[][] deleted;
    public static char[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[12][6];
        for (int i = 0; i < 12; i++) {
            arr[i] = bf.readLine().toCharArray();
        }


        while (true) {
            isContinue = false;
            visited = new boolean[12][6];
            deleted = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && arr[i][j] != '.') {
                        bfs(new Node(i, j), arr[i][j]);
                    }
                }
            }

            for (int i = 0; i < 6; i++) {
                for (int j = 11; j >= 0; j--) {
                    if (arr[j][i] == '.') {
                        int nearCharIdx = j;
                        while (nearCharIdx > 0 && arr[nearCharIdx][i] == '.') {
                            nearCharIdx--;
                        }
                        arr[j][i] = arr[nearCharIdx][i];
                        arr[nearCharIdx][i] = '.';
                    }
                }
            }

            if (!isContinue) {
                break;
            }

            ans++;
        }

        System.out.println(ans);


    }


    public static void bfs(Node startNode, char startChar) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> deletedList = new ArrayList<>();
        q.add(startNode);
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if (newX >= 0 && newX < 12 && newY >= 0 && newY < 6) {
                    if (!visited[newX][newY] && arr[newX][newY] == startChar) {
                        visited[newX][newY] = true;
                        q.add(new Node(newX, newY));
                        deletedList.add(new Node(newX, newY));
                    }
                }
            }
        }

        if (deletedList.size() >= 4) {
            for (Node node : deletedList) {
                deleted[node.x][node.y] = true;
                arr[node.x][node.y] = '.';
            }
            isContinue = true;
        }
    }

}