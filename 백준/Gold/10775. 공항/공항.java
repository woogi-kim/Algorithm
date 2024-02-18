import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int g, p;
    static int[] arr;
    static int[] gateIsIncluded;
    static int[] finalDock;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        arr = new int[p + 1];
        gateIsIncluded = new int[g + 1];
        finalDock = new int[g + 1];

        for (int i = 1; i <= p; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            boolean canDock = false;
            int start = arr[i];
            if(finalDock[arr[i]] != 0){
                start = finalDock[arr[i]];
            }
            for (int j = start; j >= 1; j--) {
                if (gateIsIncluded[j] == 0) {
                    gateIsIncluded[j] = i;
                    finalDock[arr[i]] = j;
                    canDock = true;
                    break;
                }
            }
            if (!canDock) {
                System.out.println(i - 1);
                return;
            }
        }
        System.out.println(p);

    }


}




