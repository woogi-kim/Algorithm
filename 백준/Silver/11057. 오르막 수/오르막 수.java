import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static long d[][];
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new long[n+1][10];
        long sum = 0;
        for (int i = 0; i <= 9; i++){
            sum += Calculate(n, i);
        }
        System.out.println(sum % 10007);
    }

    public static long Calculate(int n, int k){
        if (n==1){
            return 1;
        }
        if (d[n][k] > 0){
            return d[n][k];
        }
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j <= i; j++){
                d[n][i] += Calculate(n-1, j);
                d[n][i] %= 10007;
            }   
        }
        return d[n][k];
    }
}