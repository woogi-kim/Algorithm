import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int ans;
    public static int[] balloon;
    public static int[] arrows;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        balloon = new int[n];
        String[] s = bf.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(s[i]);
            balloon[i] = h;
            max = Math.max(h, max);
        }
        arrows = new int[max + 1];

        for (int i = 0; i < n; i++) {
            if (arrows[balloon[i]] == 0) {
                if (balloon[i] > 1) {
                    arrows[balloon[i] - 1]++;
                }
                ans++;
            } else {
                arrows[balloon[i]]--;
                if (balloon[i] > 1) {
                    arrows[balloon[i] - 1]++;
                }
            }

        }
        System.out.println(ans);
    }


}