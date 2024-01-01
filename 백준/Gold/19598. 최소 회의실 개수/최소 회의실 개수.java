import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    public static int ans;
    public static int n;
    public static int[][] input;
    public static boolean[] isAllocated;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        input = new int[n][2];
        isAllocated = new boolean[n];
        Arrays.fill(isAllocated, false);
        for (int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");
            input[i][0] = Integer.parseInt(tmp[0]);
            input[i][1] = Integer.parseInt(tmp[1]);
        }

        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(input[0][1]);
        for (int i = 1; i < n; i++) {
            if(pq.peek() <= input[i][0]){
                pq.poll();
            }
            pq.add(input[i][1]);
        }
        System.out.println(pq.size());
    }


}


