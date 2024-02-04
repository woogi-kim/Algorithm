
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int ans;
    public static int h;
    public static int w;
    public static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        h = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);
        arr = new boolean[h][w];
        s = bf.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(s[i]);
            for (int j = h - 1; j >= h - height; j--) {
                arr[j][i] = true;
            }
        }

        for (int i = h - 1; i >= 0; i--) {
            boolean isCounting = false;
            int count = 0;
            for (int j = 0; j < w; j++) {
                if (!isCounting && arr[i][j]) {
                    if (j + 1 <= w - 1 && !arr[i][j + 1]) {
                        isCounting = true;
                    }
                } else if (isCounting && !arr[i][j]) {
                    count++;
                } else if (isCounting && arr[i][j]) {
                    isCounting = false;
                    ans += count;
                    count = 0;
                } else if (!isCounting && !arr[i][j]) {
                    if (j - 1 >= 0 && arr[i][j - 1]) {
                        isCounting = true;
                        count = 1;
                    }
                }
            }
        }

        System.out.println(ans);
    }


}




