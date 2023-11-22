import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int num;
    int weight;

    public Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}

public class Main {
    public static int n, r;
    public static int gigaNodeNum;
    public static int gigaLength;
    public static int maxBranchLengh = Integer.MIN_VALUE;
    public static boolean[] visited;
    public static ArrayList<Node>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[a].add(new Node(b, d));
            arr[b].add(new Node(a, d));
        }
        getGigaNdoe(0, 0, r);
        getLongBranchLength(gigaNodeNum, 0);
        System.out.println(gigaLength + " " + maxBranchLengh);
    }

    public static void getGigaNdoe(int depth, int sum, int current) {
        visited[current] = true;
        if ((current != r && arr[current].size() > 2) || (current == r && arr[current].size() > 1) || depth == n - 1) {
            gigaLength = sum;
            gigaNodeNum = current;
            return;
        }
        for (int i = 0; i < arr[current].size(); i++) {
            Node node = arr[current].get(i);
            if (!visited[node.num]) {
                getGigaNdoe(depth + 1, sum + node.weight, node.num);
            }
        }
    }

    public static void getLongBranchLength(int current, int length) {
        visited[current] = true;
        if (arr[current].size() == 1 || (current == gigaNodeNum && arr[current].size() == 0)) {
            maxBranchLengh = Math.max(maxBranchLengh, length);
            return;
        }
        for (int i = 0; i < arr[current].size(); i++) {
            Node node = arr[current].get(i);
            if (!visited[node.num]) {
                getLongBranchLength(node.num, length + node.weight);
            }
        }
    }
}

