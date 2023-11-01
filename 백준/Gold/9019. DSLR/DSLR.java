import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, start, target;
    public static StringBuilder ans;
    public static boolean[] visited;
    public static int[] parent;
    public static char[] parentOp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            parent = new int[10000];
            parentOp = new char[10000];
            ans = new StringBuilder();
            bfs(start);
            System.out.println(ans);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            Integer current = q.remove();
            if (current == target) {
                while (current != start) {
                    ans.append(parentOp[current]);
                    current = parent[current];
                }
                ans.reverse();
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
                        tmp = shiftLeft(current);
                        op = 'L';
                        break;
                    case 3:
                        tmp = shiftRight(current);
                        op = 'R';
                        break;
                }
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    parent[tmp] = current;
                    parentOp[tmp] = op;
                    q.add(tmp);
                }
            }
        }
    }

    public static int shiftRight(int current) {
        StringBuilder currentStr = new StringBuilder(String.valueOf(current));
        if (currentStr.length() < 4) {
            int n = 4 - currentStr.length();
            for (int i = 0; i < n; i++) {
                currentStr.insert(0, "0");
            }
        }
        char[] currentChars = currentStr.toString().toCharArray();
        char lastDigit = currentChars[3];
        for (int i = 3; i >= 1; i--) {
            currentChars[i] = currentChars[i-1];
        }
        currentChars[0] = lastDigit;
        return Integer.parseInt(String.valueOf(currentChars));
    }

    public static int shiftLeft(int current) {
        char[] currentChars = String.valueOf(current).toCharArray();
        char[] newChars = new char[4];
        if (currentChars.length == 4) {
            for (int j = 0; j < 4; j++) {
                newChars[j] = currentChars[j < 3 ? j + 1 : 0];
            }
            return Integer.parseInt(String.valueOf(newChars));
        } else {
            return current * 10;
        }
    }
}
