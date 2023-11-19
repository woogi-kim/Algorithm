import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.util.*;

public class Main {
    public static int n;
    public static int ans;
    public static int root;
    public static int[] parent;
    public static boolean[] visit;
    public static int delete;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        parent = new int[n];
        visit = new boolean[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1){
                root = i;
            }
        }
        delete = Integer.parseInt(bf.readLine());

        deleteNode(delete);

        countLeaf(root);

        System.out.println(ans);
    }

    public static void deleteNode(int d) {
        parent[d] = -2;
        for (int i = 0; i < n; i++) {
            if (parent[i] == d) {
                deleteNode(i);
            }
        }
    }

    public static void countLeaf(int s) {
        boolean isLeaf = true;
        visit[s] = true;
        if (parent[s] != -2) {
            for (int i = 0; i < n; i++) {
                if(parent[i]== s){
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) {
                ans++;
            }
        }
    }


}

