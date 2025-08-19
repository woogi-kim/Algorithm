import java.io.*;

public class Main {
    static String S, T;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine().trim();
        T = br.readLine().trim();

        dfs(T);
        System.out.println(ans);
    }

    static void dfs(String cur) {
        if (ans == 1) return;                 // 이미 찾았으면 더 안 탐색
        if (cur.length() == S.length()) {
            if (cur.equals(S)) ans = 1;       // 도착
            return;
        }
        // 끝이 A면 A 제거
        if (cur.charAt(cur.length() - 1) == 'A') {
            dfs(cur.substring(0, cur.length() - 1));
        }
        // 시작이 B면 B 제거하고 뒤집기
        if (cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur.substring(1));
            dfs(sb.reverse().toString());
        }
    }
}