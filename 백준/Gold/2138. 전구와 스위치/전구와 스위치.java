import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int ans = Integer.MAX_VALUE;
    public static int cnt1, cnt2;
    public static boolean[] arr1;
    public static boolean[] arr2;
    public static boolean[] target;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr1 = new boolean[n];
        arr2 = new boolean[n];
        target = new boolean[n];
        String s = bf.readLine();
        for (int i = 0; i < n; i++) {
            arr1[i] = s.charAt(i) == '1';
            arr2[i] = arr1[i];
        }

        s = bf.readLine();
        for (int i = 0; i < n; i++) {
            target[i] = s.charAt(i) == '1';
        }

        clickSwitch(arr2, 0);
        cnt2++;

        for (int i = 1; i < n; i++) {
            if (arr1[i - 1] != target[i - 1]) {
                clickSwitch(arr1, i);
                cnt1++;
            }
        }

        for (int i = 1; i < n; i++) {
            if (arr2[i - 1] != target[i - 1]) {
                clickSwitch(arr2, i);
                cnt2++;
            }
        }

        check();

        System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
    }


    public static void clickSwitch(boolean[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i > -1 && i < n) {
                arr[i] = !arr[i];
            }
        }
    }

    public static void check() {
        boolean isSame1 = true;
        boolean isSame2 = true;

        for (int i = 0; i < n; i++) {
            if (arr1[i] != target[i]) {
                isSame1 = false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr2[i] != target[i]) {
                isSame2 = false;
            }
        }

        if (isSame1) {
            ans = Math.min(ans, cnt1);
        }
        if (isSame2) {
            ans = Math.min(ans, cnt2);
        }
    }
}