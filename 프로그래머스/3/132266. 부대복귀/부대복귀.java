import java.util.*;

class Solution {
    public static int[] visited;
    public static ArrayList<Integer>[] adjList;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            adjList[road[0]].add(road[1]);
            adjList[road[1]].add(road[0]);
        }
        
        bfs(destination);
        
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = visited[sources[i]];
        }
        
        return answer;
    }
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : adjList[cur]) {
                // 이미 방문했다면 스킵
                if (visited[next] != -1) {
                    continue;
                }
                
                // 방문하지 않았다면 visited 갱신하고 큐에 삽입
                visited[next] = visited[cur] + 1;
                q.add(next);
            }
        }
    }
}