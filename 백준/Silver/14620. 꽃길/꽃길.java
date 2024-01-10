import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int ans = Integer.MAX_VALUE;
    public static int[] dx = {0, 1, 0, -1, 0};
    public static int[] dy = {0, 0, 1, 0, -1};
    public static boolean[][] isMarked;
    public static boolean[] isSelected;
    public static int[][] costArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        costArr = new int[n][n];
        isSelected = new boolean[n * n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                costArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0);
        System.out.println(ans);
    }


    public static void solve(int depth, int start) {
        if (depth == 3) {
            isMarked = new boolean[n][n];
            int cost = 0;
            for (int i = 0; i < n * n; i++) {
                if (isSelected[i]) {
                    int x = i / n;
                    int y = i % n;
                    if (x == 0 || x == n - 1 || y == 0 || y == n - 1) {
                        return;
                    }
                    for (int j = 0; j < 5; j++) {
                        int newX = x + dx[j];
                        int newY = y + dy[j];
                        if (newX >= n || newX < 0 || newY >= n || newY < 0) {
                            return;
                        }
                        if (isMarked[newX][newY]) {
                            return;
                        }
                        isMarked[newX][newY] = true;
                        cost += costArr[newX][newY];
                    }
                }
            }
            ans = Math.min(cost, ans);
        } else {
            for (int i = start; i < n * n; i++) {
                isSelected[i] = true;
                solve(depth + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }


}