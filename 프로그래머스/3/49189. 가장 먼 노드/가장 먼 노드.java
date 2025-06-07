import java.util.*;

class Solution {
    public static ArrayList<Integer>[] adjList;
    public static int[] visited;
    public static int max;
    
    public int solution(int n, int[][] edges) {
        adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        visited = new int[n + 1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : adjList[cur]) {
                if (visited[next] > 0) {
                    continue;
                }
                
                visited[next] = visited[cur] + 1;
                q.add(next);
                max = Math.max(max, visited[next]);
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == max) {
                answer++;
            }
        }
        
        System.out.println(Arrays.toString(visited));
        return answer;
    }
}