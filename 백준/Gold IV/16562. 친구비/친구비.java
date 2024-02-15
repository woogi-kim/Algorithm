import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int[] parent;
    public static int[] fee;
    public static ArrayList<Integer>[] adjList;
    public static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        parent = new int[n + 1];
        fee = new int[n + 1];
        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        s = bf.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            fee[i] = Integer.parseInt(s[i - 1]);
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            s = bf.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            union(x, y);
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = find(i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(parent[i])) {
                map.put(parent[i], fee[i]);
            } else {
                map.put(parent[i], Math.min(map.get(parent[i]), fee[i]));
            }
        }
        
        for (int fee : map.values()) {
            ans += fee;
        }
        
        System.out.println(ans > k ? "Oh no" : ans);
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a != b){
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }

    }

}




