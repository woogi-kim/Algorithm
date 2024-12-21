import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Rectangle {
    int width;
    int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

public class Main {
    public static int n;
    public static Rectangle[] rectangles;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        rectangles = new Rectangle[n];
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            int width = Integer.parseInt(s[0]);
            int height = Integer.parseInt(s[1]);

            if (width > height) {
                rectangles[i] = new Rectangle(width, height);
            } else {
                rectangles[i] = new Rectangle(height, width);
            }
        }

        Arrays.sort(rectangles, (o1, o2) -> {
            if (o1.width == o2.width) {
                return o1.height - o2.height;
            } else {
                return o1.width - o2.width;
            }
        });

        dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            Rectangle cur = rectangles[i];
            for (int j = 0; j < i; j++) {
                Rectangle next = rectangles[j];
                if (cur.width >= next.width && cur.height >= next.height) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}