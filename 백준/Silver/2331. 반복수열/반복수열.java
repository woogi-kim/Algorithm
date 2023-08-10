import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int ans = 0;

        arr = new ArrayList<>();

        int n = a;
        arr.add(n);
        while (true) {
            int next = 0;
            while (n > 0) {
                next += Math.pow(n % 10, p);
                n /= 10;
            }
            
            if (arr.contains(next)){
                ans = arr.indexOf(next);
                break;
            }
            else {
                arr.add(next);
                ans++;
                n = next;
            }
        }
        System.out.println(ans);
    }

}