import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static String[][] input;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            input = new String[n][2];
            for (int i = 0; i < n; i++) {
                String[] split = bufferedReader.readLine().split(" ");
                input[i][0] = split[0];
                input[i][1] = split[1];
            }

            Arrays.sort(input, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            });

            for (int i = 0; i < n; i++) {
                sb.append(input[i][0] + " " + input[i][1] + "\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}