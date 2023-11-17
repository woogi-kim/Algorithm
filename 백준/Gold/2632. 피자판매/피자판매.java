import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.util.*;

public class Main {
    public static int n, m;
    public static int target;
    public static long ans;
    public static int[] aPizza;
    public static int[] bPizza;
    public static HashMap<Integer, Integer> aPizzaSum = new HashMap<>();
    public static HashMap<Integer, Integer> bPizzaSum = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        aPizza = new int[n];
        bPizza = new int[m];
        int aTotalSum = 0;
        int bTotalSum = 0;
        for (int i = 0; i < n; i++) {
            aPizza[i] = Integer.parseInt(bf.readLine());
            aTotalSum += aPizza[i];
        }
        for (int i = 0; i < m; i++) {
            bPizza[i] = Integer.parseInt(bf.readLine());
            bTotalSum += bPizza[i];
        }
        findSum(aPizza, aPizzaSum);
        findSum(bPizza, bPizzaSum);
        aPizzaSum.put(aTotalSum, 1);
        bPizzaSum.put(bTotalSum, 1);
        aPizzaSum.put(0, 1);
        bPizzaSum.put(0, 1);

        for(int sum : aPizzaSum.keySet()){
            int cnt = bPizzaSum.getOrDefault(target - sum, -1);
            if(cnt != -1){
                ans += (long) cnt * aPizzaSum.get(sum);
            }
        }
        System.out.println(ans);
    }

    public static void findSum(int[] slice, HashMap<Integer, Integer> sliceSum) {
        for (int i = 0; i < slice.length; i++) {
            int sum = 0;
            int idx = i;
            while (true) {
                sum += slice[idx % slice.length];
                sliceSum.putIfAbsent(sum, 0);
                sliceSum.replace(sum, sliceSum.get(sum) + 1);
                idx++;
                if (idx - i + 1 >= slice.length) {
                    break;
                }
            }
        }
        return;
    }
}

