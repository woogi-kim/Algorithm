import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    public static int n;
    public static int[] distance;
    public static boolean[] visited;

    public static ArrayList<Node>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        for (int i = 1; i <= n; i++) {
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

        visited[1] = true;
        bfs(1);
        int maxLengthNodeIdx = 1;
        for (int i = 2; i <= n; i++) {
            if (distance[maxLengthNodeIdx] < distance[i]) {
                maxLengthNodeIdx = i;
            }
        }

        visited = new boolean[n + 1];
        distance = new int[n + 1];
        visited[maxLengthNodeIdx] = true;
        bfs(maxLengthNodeIdx);
        maxLengthNodeIdx = 1;
        for (int i = 2; i <= n; i++) {
            if (distance[maxLengthNodeIdx] < distance[i]) {
                maxLengthNodeIdx = i;
            }
        }
        System.out.println(distance[maxLengthNodeIdx]);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr[start].size(); i++) {
            q.add(arr[start].get(i).num);
            distance[arr[start].get(i).num] = arr[start].get(i).weight;
            visited[arr[start].get(i).num] = true;
        }

        while (!q.isEmpty()) {
            Integer currentNode = q.remove();
            for (Node newNode : arr[currentNode]) {
                if (!visited[newNode.num]) {
                    q.add(newNode.num);
                    distance[newNode.num] = distance[currentNode] + newNode.weight;
                    visited[newNode.num] = true;
                }
            }
        }
    }

}

