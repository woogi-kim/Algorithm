import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, start, target;
    public static boolean[] visited;
    public static String[] command;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            command = new String[10000];
            Arrays.fill(command, "");
            bfs(start);
            System.out.println(command[target]);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            Integer current = q.remove();
            if (current == target) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int tmp = 0;
                char op = '0';
                switch (i) {
                    case 0:
                        tmp = (current * 2) % 10000;
                        op = 'D';
                        break;
                    case 1:
                        tmp = current > 0 ? current - 1 : 9999;
                        op = 'S';
                        break;
                    case 2:
                        tmp = (current % 1000) * 10 + current / 1000;
                        op = 'L';
                        break;
                    case 3:
                        tmp = (current % 10) * 1000 + current / 10;
                        op = 'R';
                        break;
                }
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    command[tmp] = command[current] + op;
                    q.add(tmp);
                }
            }
        }
    }

}
