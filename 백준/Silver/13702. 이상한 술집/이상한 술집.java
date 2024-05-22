import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static int k;
    public static int[] volume;
    public static long maxVolume;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        volume = new int[n];

        for (int i = 0; i < n; i++) {
            volume[i] = Integer.parseInt(bf.readLine());
            maxVolume += volume[i];
        }

        maxVolume = (maxVolume / k) + 1;

        long l = 1;
        long r = (int) maxVolume;
        long mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += volume[j] / mid;
            }

            if (count < k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l - 1);
    }


}