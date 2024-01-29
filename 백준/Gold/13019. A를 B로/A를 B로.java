import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String a = bf.readLine();
        String b = bf.readLine();
        char[] aChar = new char[26];
        char[] bChar = new char[26];
        for (int i = 0; i < a.length(); i++) {
            aChar[a.charAt(i) - 'A']++;
            bChar[b.charAt(i) - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (aChar[i] != bChar[i]) {
                System.out.println(-1);
                exit(0);
            }
        }
        int idx = a.length() - 1;
        int cnt = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == b.charAt(idx)) {
                idx--;
            } else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }


}