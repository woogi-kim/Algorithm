import java.util.*;

class Solution {
    class Node {
        int num;
        int dist;
        public Node (int num ,int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
    
    public static ArrayList<Node>[] adjList;
    public static int[] dists;
    public int solution(int n, int[][] roads, int K) {
        int answer = 0;
        dists = new int[n + 1];
        
        adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            adjList[road[0]].add(new Node(road[1], road[2]));
            adjList[road[1]].add(new Node(road[0], road[2]));
        }
        
        Arrays.fill(dists, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        int start = 1;
        pq.add(new Node(start, 0));
        dists[start] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist > dists[cur.num]){
                continue;
            }
            
            
            for (int i = 0; i < adjList[cur.num].size(); i++) {
                if (dists[adjList[cur.num].get(i).num] > dists[cur.num] + adjList[cur.num].get(i).dist) {
                    pq.add(new Node(adjList[cur.num].get(i).num, dists[cur.num] + adjList[cur.num].get(i).dist));
                
                dists[adjList[cur.num].get(i).num] = dists[cur.num] + adjList[cur.num].get(i).dist;
                }
                
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dists[i] <= K) {
                count++;
            }
        }
        return count;
    }
}