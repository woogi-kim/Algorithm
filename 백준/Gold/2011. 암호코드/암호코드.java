import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dp;
    public static int[] input;
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] strings = bufferedReader.readLine().split("");
            n = strings.length;

            dp = new int[n + 1];
            input = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                input[i] = Integer.parseInt(strings[i - 1]);
            }


            if (input[1] == 0) {
                System.out.println(0);
                return;
            }

            dp[0] = 1;
            dp[1] = 1;

//                if (n >= 2) {
//                    if((1 <= input[1] * 10 + input[2] && input[1] * 10 + input[2] <= 26) && input[2] != 0){
//                        dp[2] = 0;
//                    }
//                    if (!(1 <= input[1] * 10 + input[2] && input[1] * 10 + input[2] <= 26) && input[2] == 0) {
//                        System.out.println(0);
////                        return;
//                    } else{
//                        dp[2] = 1;
//                    }
//                }
            for (int i = 2; i <= n; i++) {
                if (input[i] != 0) {
                    dp[i] += dp[i - 1];
                    dp[i] %= 1000000;
                }
                if (10 <= input[i - 1] * 10 + input[i] && input[i - 1] * 10 + input[i] <= 26) {
                    dp[i] += dp[i - 2];
                    dp[i] %= 1000000;
                } else if (input[i] == 0) {
                    System.out.println(0);
                    return;
                }
            }
//                for (int i : dp) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
            System.out.println(dp[n]);
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}