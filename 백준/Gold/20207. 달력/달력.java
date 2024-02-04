
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int ans;
    public static int n;
    public static int allEnd;
    public static int[] schedule;
    public static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        schedule = new int[366];
        input = new int[n][2];
        for (int i = 1; i <= n; i++) {
            String[] s = bf.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            allEnd = Math.max(end, allEnd);

            input[i - 1][0] = start;
            input[i - 1][1] = end;

        }

        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return (o2[1] - o2[0]) - (o1[1] - o1[0]);
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = input[i][0]; j <= input[i][1]; j++) {
                schedule[j]++;
            }
        }


        int maxHeight = 0;
        int maxWidth = 0;
        for (int i = 1; i <= allEnd; i++) {
            if (schedule[i] == 0) {
                ans += maxHeight * maxWidth;
                maxWidth = 0;
                maxHeight = 0;
            } else {
                maxWidth++;
                maxHeight = Math.max(maxHeight, schedule[i]);
            }
        }
        ans += maxHeight * maxWidth;

        System.out.println(ans);

    }


}




