import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int ans;
    public static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                if (isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                arr.add(i);
            }
        }
        
        int size = arr.size();
        arr.add(0);

        int start = 0;
        int end = 0;
        int sum = 0;
        while (end <= size && start <= size) {
            if (sum < n) {
                sum += arr.get(end);
                end++;
            } else {
                sum -= arr.get(start);
                start++;
            }
            if(sum == n){
                ans++;
            }
        }
        System.out.println(ans);
    }


}
