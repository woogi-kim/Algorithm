import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int[] max = new int[3];
    public static boolean[][][] visited = new boolean[201][201][201];
    public static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        max[0] = Integer.parseInt(s[0]);
        max[1] = Integer.parseInt(s[1]);
        max[2] = Integer.parseInt(s[2]);
        bfs(0, 0, max[2]);
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (Integer a : ans) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }

    public static void bfs(int a, int b, int c) {
        Queue<int[]> q = new LinkedList<>();
        int[] init = {a, b, c};
        q.add(init);
        ans.add(c);
        visited[a][b][c] = true;
        while (!q.isEmpty()) {
            int[] current = q.remove();
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j <= 2; j++) {
                    int[] next = Arrays.copyOf(current, 3);
                    int sum = current[i] + current[(i + j) % 3];
                    next[i] = Math.min(max[i], sum);
                    next[(i + j) % 3] = sum >= max[i] ? sum - max[i] : 0;
                    if (!visited[next[0]][next[1]][next[2]]) {
                        q.add(next);
                        visited[next[0]][next[1]][next[2]] = true;
                        if (next[0] == 0 && !ans.contains(next[2])) {
                            ans.add(next[2]);
                        }
                    }
                }
            }
        }
    }

}

