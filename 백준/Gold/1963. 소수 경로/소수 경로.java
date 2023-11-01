import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, start, target;
    public static int ans;
    public static boolean[] isPrime = new boolean[10000];
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        eratos();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            ans = Integer.MAX_VALUE;
            visited = new int[10000];

            bfs(start);
            System.out.println(ans);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        while (!q.isEmpty()) {
            Integer current = q.remove();
            if (current == target) {
                ans = visited[target] - 1;
                return;
            }
            for (int i = 0; i < 4; i++) {
                char[] numbers = String.valueOf(current).toCharArray();
                for (int j = 0; j < 10; j++) {
                    numbers[i] = (char) ('0' + j);
                    int next = Integer.parseInt(String.valueOf(numbers));
                    if (visited[next] == 0 && next >= 1000 && next <= 9999 && isPrime[next]) {
                        visited[next] = visited[current] + 1;
                        q.add(next);
                    }
                }
            }
        }
    }

    public static void eratos() {
        for (int i = 2; i < 10000; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < 10000; i++) {
            for (int j = i * i; j < 10000; j += i) {
                isPrime[j] = false;
            }
        }
    }

}
