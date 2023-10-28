import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer> plus = new ArrayList<>();
    public static ArrayList<Integer> minus = new ArrayList<>();
    public static Integer one = 0;
    public static Integer n;
    public static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            Integer input = Integer.parseInt(bf.readLine());
            if (input > 1)
                plus.add(input);
            else if (input < 1)
                minus.add(input);
            else
                one++;
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        if ((minus.size() % 2) == 1) {
            sum += minus.get(minus.size() - 1);
        }

        if (minus.size() > 1) {
            for (int i = 0; i < minus.size() - 1; i += 2) {
                sum += minus.get(i) * minus.get(i + 1);
            }
        }

        if ((plus.size() % 2) == 1) {
            sum += plus.get(plus.size() - 1);
        }


        if (plus.size() > 1) {
            for (int i = 0; i < plus.size() - 1; i += 2) {
                sum += plus.get(i) * plus.get(i + 1);
            }
        }

        sum += one;
        System.out.println(sum);
    }
}

