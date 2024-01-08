import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int ans;
    public static String[] question;
    public static int[] strikes;
    public static int[] balls;
    public static boolean[] isIncluded;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        question = new String[n];
        strikes = new int[n];
        balls = new int[n];
        isIncluded = new boolean[10];
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            question[i] = s[0];
            strikes[i] = Integer.parseInt(s[1]);
            balls[i] = Integer.parseInt(s[2]);
        }
        solve(0, 0);
        System.out.println(ans);
    }

    public static void solve(int depth, int num) {
        if (depth == 3) {
            num /= 10;
            for (int i = 0; i < n; i++) {
                int strike = 0;
                int ball = 0;
                String current = Integer.toString(num);
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (current.charAt(j) == question[i].charAt(k)) {
                            if (j == k) {
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }
                }
                if (!(strike == strikes[i] && ball == balls[i])){
                    return;
                }
            }
            ans++;
        } else {
            for (int i = 1; i < 10; i++) {
                if (!isIncluded[i]) {
                    isIncluded[i] = true;
                    solve(depth + 1, (num + i) * 10);
                    isIncluded[i] = false;
                }
            }
        }

    }
}


