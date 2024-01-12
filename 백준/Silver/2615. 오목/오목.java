
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {0, 1, 1, -1};
    public static int[] dy = {1, 0, 1, 1};
    public static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 19; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        

        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (input[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        if (isSameStoneInLine(i, j, k)) {
                            System.out.println(input[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);

    }

    public static boolean isSameStoneInLine(int i, int j, int k) {
        int newX = i;
        int newY = j;
        int cnt = 1;
        while (true) {
            newX += dx[k];
            newY += dy[k];
            if (newX >= 0 && newX < 19 && newY >= 0 && newY < 19) {
                if (input[newX][newY] != input[i][j]) {
                    break;
                }
                cnt++;
            } else {
                break;
            }
        }

        newX = i;
        newY = j;
        while (true) {
            newX -= dx[k];
            newY -= dy[k];
            if (newX >= 0 && newX < 19 && newY >= 0 && newY < 19) {
                if (input[newX][newY] != input[i][j]) {
                    break;
                }
                cnt++;
            } else {
                break;
            }
        }
        return cnt == 5;
    }
}
