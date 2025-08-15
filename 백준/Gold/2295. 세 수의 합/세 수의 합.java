import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(br.readLine());
        Arrays.sort(a);

        // 1) 모든 두 수 합
        int M = N * N;
        int[] two = new int[M];
        int t = 0;
        for (int i = 0; i < N; i++) {
            // 문제에서 x,y,z,k는 서로 같아도 되므로 i=j 허용
            for (int j = 0; j < N; j++) {
                two[t++] = a[i] + a[j];
            }
        }
        Arrays.sort(two);

        // 2) d = a[i]를 큰 것부터, c = a[j]를 모든 j에 대해 확인
        for (int i = N - 1; i >= 0; i--) {      // d 후보
            for (int j = 0; j < N; j++) {       // c 후보
                int need = a[i] - a[j];         // need = a[x] + a[y]
                if (exists(two, need)) {
                    System.out.println(a[i]);   // 가장 큰 d를 찾자마자 출력
                    return;
                }
            }
        }
    }

    // two[]는 정렬되어 있음
    static boolean exists(int[] two, int key) {
        int l = 0, r = two.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (two[mid] == key) return true;
            if (two[mid] < key) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}