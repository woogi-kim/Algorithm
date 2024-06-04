import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n;
    public static int[] arr;
    public static boolean[] isVisited;
    public static boolean[] operator;
    public static int add;
    public static int mul;
    public static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        arr = new int[n];
        isVisited = new boolean[n];
        operator = new boolean[n - 1];

        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        s = bf.readLine().split(" ");
        add = Integer.parseInt(s[0]);
        mul = Integer.parseInt(s[1]);

        permutation(0, new ArrayList<>());
        System.out.println(ans);
    }

    public static void permutation(int depth, ArrayList<Integer> list) {
        if (depth == n) {
            combination(0, 0, list);
        } else {
            for (int i = 0; i < n; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    ArrayList<Integer> current = (ArrayList<Integer>) list.clone();
                    current.add(arr[i]);
                    permutation(depth + 1, current);
                    isVisited[i] = false;
                }
            }
        }
    }

    public static void combination(int depth, int start, ArrayList<Integer> list) {
        if (depth == add) {
            int[] sum = new int[mul + 1];
            int idx = 0;
            sum[0] = list.get(0);
            for (int i = 0; i < n - 1; i++) {
                if(operator[i]) {
                    sum[idx] += list.get(i + 1);
                } else {
                    idx++;
                    sum[idx] = list.get(i + 1);
                }
            }
            int res = 1;
            for (int s : sum) {
                res *= s;
            }
            ans = Math.max(res, ans);
            return;
        }

        for (int i = start; i < n - 1; i++) {
            if (!operator[i]) {
                operator[i] = true;
                combination(depth + 1, i + 1, list);
                operator[i] = false;
            }
        }
    }
}
