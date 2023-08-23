import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static String input;
    public static int[] count = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = bf.readLine().split("");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            sum += num;
            count[num]++;
        }

        if (sum % 3 == 0 && count[0] != 0) {
            for (int i = 9; i >= 0; i--) {
                while(count[i] > 0){
                    sb.append(i);
                    count[i]--;
                }
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}

