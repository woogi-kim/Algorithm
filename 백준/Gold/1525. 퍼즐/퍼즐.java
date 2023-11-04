import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final String targetPuzzleString = "123456780";
    public static HashMap<String, Integer> visited = new HashMap<String, Integer>();
    public static int ans;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                start.append(st.nextToken());
            }
        }
        bfs(start.toString());
        System.out.println(ans);
    }

    public static void bfs(String start) {
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.put(start, 1);
        while (!q.isEmpty()) {
            String currentStr = q.remove();
            int posX = currentStr.indexOf("0") / 3;
            int posY = currentStr.indexOf("0") % 3;
            if (currentStr.equals(targetPuzzleString)) {
                ans = visited.get(currentStr) - 1;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newPosX = posX + dx[i];
                int newPosY = posY + dy[i];
                if (newPosX < 3 && newPosX >= 0 && newPosY < 3 && newPosY >= 0) {
                    int newIdx = 3 * newPosX + newPosY;
                    String newStr = currentStr;

                    char ch = currentStr.charAt(newIdx);
                    newStr = newStr.replace(ch, '9');
                    newStr = newStr.replace('0', ch);
                    newStr = newStr.replace('9', '0');

                    if (!visited.containsKey(newStr)) {
                        visited.put(newStr, visited.get(currentStr) + 1);
                        q.add(newStr);
                    }
                }
            }
        }
        ans = -1;
    }

}

