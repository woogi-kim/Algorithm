import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static char[][] input;
    public static StringBuilder sb = new StringBuilder();
    public static int hammingDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        input = new char[n][m];
        for (int i = 0; i < n; i++) {
            input[i] = bf.readLine().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            int[] count = new int[4];
            for (int j = 0; j < n; j++) {
                switch (input[j][i]) {
                    case 'A':
                        count[0]++;
                        break;
                    case 'C':
                        count[1]++;
                        break;
                    case 'G':
                        count[2]++;
                        break;
                    case 'T':
                        count[3]++;
                        break;
                }
            }
            int max = count[0];
            int maxIdx = 0;
            for (int j = 1; j < 4; j++) {
                if (max < count[j]) {
                    max = count[j];
                    maxIdx = j;
                }
            }

            hammingDistance += n - max;
            switch (maxIdx) {
                case 0:
                    sb.append('A');
                    break;
                case 1:
                    sb.append('C');
                    break;
                case 2:
                    sb.append('G');
                    break;
                case 3:
                    sb.append('T');
                    break;
            }
        }
        System.out.println(sb.toString());
        System.out.println(hammingDistance);
    }


}


