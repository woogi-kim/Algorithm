import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int num;
    Node leftChild;
    Node rightChild;

    public Node(int num) {
        this.num = num;
    }
}

public class Main {
    public static int t;
    public static int n;
    public static int[] preOrder;
    public static int[] inOrder;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            preOrder = new int[n + 1];
            inOrder = new int[n + 1];
            String[] tmp = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                preOrder[j + 1] = Integer.parseInt(tmp[j]);
            }

            tmp = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                inOrder[j + 1] = Integer.parseInt(tmp[j]);
            }
            int rootIdx = 0;
            for (int j = 1; j <= n; j++) {
                if (preOrder[1] == inOrder[j]) {
                    rootIdx = j;
                }
            }

            makeTree(1, 1, n + 1);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void makeTree(int root, int start, int end) {
        int rootIdx = -1;
        for (int i = start; i < end; i++) {
            if (preOrder[root] == inOrder[i]) {
                rootIdx = i;
                break;
            }
        }
        if (rootIdx == -1) {
            return;
        }

        makeTree(root + 1, start, rootIdx);
        makeTree(root + (rootIdx - start + 1), rootIdx + 1, end);
        sb.append(preOrder[root] + " ");
    }


}




