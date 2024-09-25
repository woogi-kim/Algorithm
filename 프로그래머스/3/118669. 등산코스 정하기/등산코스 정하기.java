import java.util.*;


class Solution {
    public ArrayList<Node>[] graph;
    public int minSummit = Integer.MAX_VALUE;
    public int minIntensity = Integer.MAX_VALUE;
    public boolean[] isSummits;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        isSummits = new boolean[n + 1];
        for (int i=0; i<summits.length; i++) {
            isSummits[summits[i]] = true;
        }
        
        for (int i = 0; i < paths.length; i++) {
            int start = paths[i][0];
            int end = paths[i][1];
            int cost = paths[i][2];
            
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }
        
      
        dijkstra(0, n, summits, gates);
        
        
        int[] answer = new int[2];
        answer[0] = minSummit;
        answer[1] = minIntensity;
        
        return answer;
    }
    
    public void dijkstra(int start, int n, int[] summits, int[] gates) {
        int[] intensities = new int[n + 1];
        Arrays.fill(intensities, Integer.MAX_VALUE);
        
        boolean[] visited = new boolean[n + 1];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        
        for(int gate: gates) {
            intensities[gate] = 0;
            pq.add(new Node(gate, 0));
        }
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (intensities[current.idx] < current.cost) continue;
            
            
            for (Node node : graph[current.idx]) { 
                if (intensities[node.idx] <= Math.max(current.cost, node.cost)) continue;
                intensities[node.idx] = Math.max(current.cost, node.cost);
                if (isSummits[node.idx]) continue;
                pq.add(new Node(node.idx, intensities[node.idx]));
            }        

        }
   
        
        
        for (int summit : summits) {
            if (minIntensity > intensities[summit]) {
                minIntensity = intensities[summit];
                minSummit = summit;
            } else if (minIntensity == intensities[summit]) {
                minSummit = Math.min(minSummit, summit);
            }
        }
        System.out.println("summit : "+ minSummit + " "+minIntensity);
    }
}

class Node {
    int idx;
    int cost;
    
    Node (int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}