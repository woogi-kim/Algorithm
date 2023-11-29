import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int num;
    Node left;
    Node right;

    public Node(int num) {
        this.num = num;
    }
}

public class Main {
    public static int n;
    public static int count = 1;
    public static int root;
    public static int maxDepth;
    public static int[][] input;
    public static boolean[] isRoot;
    public static int[] visitOrder;
    public static int[] depth;
    public static int[] maxPerDepth;
    public static int[] minPerDepth;
    public static int maxWidth;
    public static int maxWidthDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        input = new int[n + 1][2];
        isRoot = new boolean[n + 1];
        visitOrder = new int[n + 1];
        depth = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");
            int parent = Integer.parseInt(tmp[0]);
            int leftChild = Integer.parseInt(tmp[1]);
            int rightChild = Integer.parseInt(tmp[2]);
            if (leftChild != -1) {
                isRoot[leftChild] = true;
            }
            if (rightChild != -1) {
                isRoot[rightChild] = true;
            }
            input[parent][0] = leftChild;
            input[parent][1] = rightChild;
        }

        for (int i = 1; i <= n; i++) {
            if (!isRoot[i]) {
                root = i;
                break;
            }
        }
        Node rootNode = new Node(root);
        makeTree(rootNode);
        inorder(rootNode, 1);
        maxPerDepth = new int[maxDepth + 1];
        minPerDepth = new int[maxDepth + 1];
        for (int i = 1; i <= maxDepth; i++) {
            maxPerDepth[i] = Integer.MIN_VALUE;
            minPerDepth[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            maxPerDepth[depth[i]] = Math.max(maxPerDepth[depth[i]], visitOrder[i]);
            minPerDepth[depth[i]] = Math.min(minPerDepth[depth[i]], visitOrder[i]);
        }
        for (int i = 1; i <= maxDepth; i++) {
            if (maxWidth < maxPerDepth[i] - minPerDepth[i] + 1) {
                maxWidth = maxPerDepth[i] - minPerDepth[i] + 1;
                maxWidthDepth = i;
            }
        }
        System.out.println(maxWidthDepth + " " + maxWidth);

    }

    public static void makeTree(Node node) {
        if (input[node.num][0] != -1) {
            node.left = new Node(input[node.num][0]);
            makeTree(node.left);
        }
        if (input[node.num][1] != -1) {
            node.right = new Node(input[node.num][1]);
            makeTree(node.right);
        }
    }

    public static void inorder(Node node, int dep) {
        if (node == null) {
            return;
        }
        inorder(node.left, dep + 1);
        visitOrder[node.num] = count;
        count++;
        depth[node.num] = dep;
        maxDepth = Math.max(dep, maxDepth);
        inorder(node.right, dep + 1);
    }

}




