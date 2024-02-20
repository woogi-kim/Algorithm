import java.util.*;

class Solution {
    public int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i = 0 ; i < n; i++){
            parent[i] = i;
        }
        
        int answer = 0;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(int i = 0; i < costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
    
    public int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) {
            if(a < b){
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }
}