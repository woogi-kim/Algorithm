import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static char[][] arr;
    public static char[][] partition;
    public static int[][][] colorCount;
    public static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        partition = new char[k][k];
        colorCount = new int[k][k][26];
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                colorCount[i % k][j % k][arr[i][j] - 'A']++;
            }
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int max = 0;
                for (int l = 0; l < 26; l++) {
                    if (max < colorCount[i][j][l]) {
                        max = colorCount[i][j][l];
                        partition[i][j] = (char) ('A' + l);
                    }
                }
                ans += ((n * m) / (k * k)) - max;
            }
        }
        System.out.println(ans);
//        System.out.println(ans);
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < k; j++) {
//                System.out.print(partition[i][j]);
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(partition[i % k][j % k]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
