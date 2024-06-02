import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static int n;
    public static int m;
    public static ArrayList<Integer>[] arr;
    public static int[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new ArrayList[n + 1];
        isVisited = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            arr[start].add(end);
            arr[end].add(start);
        }

        bfs(1);
        int barnIdx = 0;
        int barnDistance = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            if (barnDistance < isVisited[i]) {
                barnIdx = i;
                barnDistance = isVisited[i];
            }
        }

        int barnCount = 0;
        for (int i = 2; i <= n; i++) {
            if (barnDistance == isVisited[i]) {
                barnCount++;
            }
        }
        System.out.println(barnIdx + " " + barnDistance + " " + barnCount);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : arr[current]) {
                if (isVisited[next] == 0) {
                    q.add(next);
                    isVisited[next] = isVisited[current] + 1;
                }
            }
        }
    }
}