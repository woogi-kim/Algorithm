import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int a;
    public static int t;
    public static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(bf.readLine());
        t = Integer.parseInt(bf.readLine());
        b = Integer.parseInt(bf.readLine());
        int totalCount = 0;
        int bCount = 0;
        int dCount = 0;
        int loopCount = 4;
        while (true) {
            for (int i = 0; i < 4; i++) {
                totalCount++;
                if (i == 0 || i == 2) {
                    bCount++;
                    if (b == 0 && bCount == t) {
                        System.out.println((totalCount - 1) % a);
                        System.exit(0);
                        break;
                    }
                } else {
                    dCount++;
                    if (b == 1 && dCount == t) {
                        System.out.println((totalCount - 1) % a);
                        System.exit(0);
                        break;
                    }
                }
            }
            for (int i = 0; i < loopCount / 2; i++) {
                totalCount++;
                bCount++;
                if (b == 0 && bCount == t) {
                    System.out.println((totalCount - 1) % a);
                    System.exit(0);
                    break;
                }
            }
            for (int i = loopCount / 2; i < loopCount; i++) {
                totalCount++;
                dCount++;
                if (b == 1 && dCount == t) {
                    System.out.println((totalCount - 1) % a);
                    System.exit(0);
                    break;
                }
            }
            loopCount += 2;
        }

    }


}


