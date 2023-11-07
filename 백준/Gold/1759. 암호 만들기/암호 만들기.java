import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int l, c;
    public static String[] arr;
    public static boolean[] visited;
    public static ArrayList<Character> consonant = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[c];
        arr = bf.readLine().split(" ");
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            dfs(i, 0, arr[i]);
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int i, int depth, String str) {
        if (depth == l - 1 && check(str)) {
            sb.append(str).append('\n');
            return;
        }
        for (int j = i + 1; j < arr.length; j++) {
            dfs(j, depth + 1, str.concat(arr[j]));
        }

    }

    public static boolean check(String str) {
        int cons = 0;
        int vow = 0;
        for (int i = 0; i < str.length(); i++) {
            if (consonant.contains(str.charAt(i))) {
                cons++;
            } else {
                vow++;
            }
        }
        return cons >= 1 && vow >= 2;
    }

}
