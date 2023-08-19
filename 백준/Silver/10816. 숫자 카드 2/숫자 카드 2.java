import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] own;
    public static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(bufferedReader.readLine());
        own = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            own[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(bufferedReader.readLine());
        check = new int[m];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(own);

        for (int i = 0; i < m; i++) {
            sb.append(upperBound(i) - lowerBound(i)).append(" ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(int i) {
        int end = n;
        int start = 0;
        int mid;
        while (end > start) {
            mid = (end + start) / 2;
            if (check[i] > own[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static int upperBound(int i) {
        int end = n;
        int start = 0;
        int mid;
        while (end > start) {
            mid = (end + start) / 2;
            if (check[i] >= own[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
