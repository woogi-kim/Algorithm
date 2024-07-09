import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static long[] x;
    public static long[] y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        x = new long[n + 1];
        y = new long[n + 1];

        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            x[i] = Long.parseLong(s[0]);
            y[i] = Long.parseLong(s[1]);
        }

        x[n] = x[0];
        y[n] = y[0];
        
        long firstTerm = 0;
        for (int i = 0; i < n; i++) {
            firstTerm += x[i] * y[i + 1];
        }

        long secondTerm = 0;
        for (int i = 0; i < n; i++) {
            secondTerm += x[i + 1] * y[i];
        }

        System.out.println(String.format("%.1f", (Math.abs(firstTerm - secondTerm) / 2.0)));
    }
}
