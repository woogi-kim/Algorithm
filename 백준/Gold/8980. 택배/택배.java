import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Node {
    int from;
    int to;
    int box;

    public Node(int from, int to, int box) {
        this.from = from;
        this.to = to;
        this.box = box;
    }
}

public class Main {
    public static int n;
    public static int m;
    public static int c;
    public static Node[] arr;
    public static int[] maxLoad;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        m = Integer.parseInt(bf.readLine());
        arr = new Node[m];
        maxLoad = new int[m + 1];

        Arrays.fill(maxLoad, c);

        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            int box = Integer.parseInt(s[2]);
            arr[i] = new Node(from, to, box);
        }

        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.to == o2.to) {
                    return o1.from - o2.from;
                } else {
                    return o1.to - o2.to;
                }
            }
        });

        int ans = 0;
        for (int i = 0; i < m; i++) {
            int from = arr[i].from;
            int to = arr[i].to;
            int box = arr[i].box;
            int min = Integer.MAX_VALUE;
            for (int j = from; j < to; j++) {
                min = Math.min(min, maxLoad[j]);
            }
            min = Math.min(min, box);

            for (int j = from; j < to; j++) {
                maxLoad[j] -= min;
            }

            ans += min;
        }
        System.out.println(ans);
    }


}