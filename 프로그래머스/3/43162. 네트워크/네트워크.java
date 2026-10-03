import java.util.*;

class Solution {
    public static int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            parent[i] = find(i);
        }
        for (int p : parent) {
            set.add(p);
        }
        int answer = 0;
        return set.size();
    }
    
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        System.out.println(x + " " + y);
        System.out.println(parentX + " " + parentY);
    
        if (parentX < parentY) {
                parent[parentY] = parentX;
            }else {
                parent[parentX] = parentY;
            }
    }
}