import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] arr = new int[3][n];
        for (int t = 0; t < 3; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[t][i] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 3; t++) {
            sb.append(solve(arr[t], n)).append('\n');
        }
        System.out.print(sb.toString());
    }

    // 주어진 배열 a[0..n-1]에 대해 승자("A","B","D")를 반환
    private static char solve(int[] a, int n) {
        // prefixSum[i] = a[0] + ... + a[i-1]
        long[] ps = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + a[i - 1];
        }

        // f[i]: 길이 i 상태에서 A 차례일 때의 최적 (B_sum - A_sum)
        // g[i]: 길이 i 상태에서 B 차례일 때의 최적 (B_sum - A_sum)
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        f[0] = g[0] = 0;

        for (int i = 1; i <= n; i++) {
            // A의 차례: f[i] = max_{k=1..i} ( g[k-1] - sum(a[k-1..i-1]) )
            long bestF = Long.MIN_VALUE;
            for (int k = 1; k <= i; k++) {
                long sumSuffix = ps[i] - ps[k - 1];
                bestF = Math.max(bestF, g[k - 1] - sumSuffix);
            }
            f[i] = bestF;

            // B의 차례: g[i] = min_{k=1..i} ( f[k-1] + sum(a[k-1..i-1]) )
            long bestG = Long.MAX_VALUE;
            for (int k = 1; k <= i; k++) {
                long sumSuffix = ps[i] - ps[k - 1];
                bestG = Math.min(bestG, f[k - 1] + sumSuffix);
            }
            g[i] = bestG;
        }

        long finalValue = f[n];  // 전체 배열에서 A가 먼저 시작했을 때의 (B_sum - A_sum)
        if (finalValue > 0) return 'A';    // B_sum > A_sum → A 승리
        else if (finalValue < 0) return 'B'; // B_sum < A_sum → B 승리
        else return 'D';                     // 무승부
    }
}