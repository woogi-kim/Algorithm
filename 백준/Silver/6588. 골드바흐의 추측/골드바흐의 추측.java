import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int MAX = 1000001;
    public static int[] arr;

    public static String solve(int num) {
        for (int i = 3; i <= num; i++) {
            if (arr[i] + arr[num - i] == num && arr[i] != 0 && arr[num - i] != 0) {
                return num + " = " + i + " + " + (num - i) + "\n";
            }
        }
        return "Goldbach's conjecture is wrong.\n";
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            arr = new int[MAX];
            for (int i = 2; i < MAX; i++) {
                arr[i] = i;
            }

            for (int i = 2; i < MAX; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                for (int j = i + i; j < MAX; j += i) {
                    arr[j] = 0;
                }
            }

            while (true) {
                int num = Integer.parseInt(bufferedReader.readLine());
                if (num == 0) {
                    break;
                }
                sb.append(solve(num));
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
