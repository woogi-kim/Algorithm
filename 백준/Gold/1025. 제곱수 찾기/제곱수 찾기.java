import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static int n;
    public static int m;
    public static int[][] arr;
    public static int ans = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = bf.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }


        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = -n; k < n; k++) {
                    for (int l = -m; l < m; l++) {
                        if (k == 0 && l == 0) {
                            continue;
                        }
                        int newX = i;
                        int newY = j;
                        int tmp = 0;
                        while (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                            tmp = tmp * 10 + arr[newX][newY];
                            int root = (int) Math.sqrt(tmp);
                            if (root * root == tmp) {
                                ans = Math.max(ans, tmp);
                            }
                            newX += k;
                            newY += l;
                        }
                    }
                }

            }
        }
        System.out.println(ans == Integer.MIN_VALUE ? -1 : ans);
    }

}