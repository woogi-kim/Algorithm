import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] input;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            input = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] split = bufferedReader.readLine().split(" ");
                input[i][0] = Integer.parseInt(split[0]);
                input[i][1] = Integer.parseInt(split[1]);
            }
            Arrays.sort(input, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0])
                        return o1[1] - o2[1];
                    else
                        return o1[0] - o2[0];
                }
            });

            for (int i = 0; i < n; i++) {
                sb.append(input[i][0]+" "+input[i][1]+"\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}