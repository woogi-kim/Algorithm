import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static boolean[] isBroken;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        arr = new int[n][2];
        isBroken = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");

            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        dfs(0, 0);

        System.out.println(ans);
    }

    public static void dfs(int depth, int broken) {
        ans = Math.max(broken, ans);
//
//        System.out.println("depth : " + depth);
//        System.out.println("broken : "  + broken);
        if (depth == n) {
            return;
        }

        if (isBroken[depth]) {
            dfs(depth + 1, broken);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isBroken[i] || i == depth) {
                continue;
            }

            int durability1 = arr[depth][0];
            int durability2 = arr[i][0];

            arr[depth][0] -= arr[i][1];
            arr[i][0] -= arr[depth][1];
//
//            System.out.println("지금 뎁스 : " + depth);
//            System.out.println("피해자 인덱스 : " + i);
//            System.out.println("가해자 체력 : " + arr[depth][0]);
//            System.out.println("피해자 체력 : " + arr[i][0]);


            int nextBroken = broken;
            if (arr[depth][0] <= 0) {
                isBroken[depth] = true;
                nextBroken++;
            }

            if (arr[i][0] <= 0) {
                isBroken[i] = true;
                nextBroken++;
            }

            dfs(depth + 1, nextBroken);

            arr[depth][0] = durability1;
            arr[i][0] = durability2;

            isBroken[depth] = false;
            isBroken[i] = false;
         }
    }

}