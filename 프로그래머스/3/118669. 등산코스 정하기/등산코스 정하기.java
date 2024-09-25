import java.util.*;

class Node {
    int idx;
    int cost;
    
    Node (int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}
class Solution {
    public ArrayList<Node>[] graph;
    public int minSummit = Integer.MAX_VALUE;
    public int minIntensity = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < paths.length; i++) {
            int start = paths[i][0];
            int end = paths[i][1];
            int cost = paths[i][2];
            
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }
        
        for (int gate : gates) {
            dijkstra(gate, n, summits);
        }
        
        int[] answer = new int[2];
        answer[0] = minSummit;
        answer[1] = minIntensity;
        
        return answer;
    }
    
    public void dijkstra(int start, int n, int[] summits) {
        int[] intensities = new int[n + 1];
        Arrays.fill(intensities, Integer.MIN_VALUE);
        
        boolean[] visited = new boolean[n + 1];
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        
        intensities[start] = 0;
        visited[start] = true;
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            for (Node node : graph[current.idx]) {
                if (visited[node.idx]) {
                    continue;
                }
                System.out.println("node : " + current.idx + " " + node.idx);
                if (current.idx == start) {
                    System.out.println("intensity : " + intensities[node.idx] + " " + node.cost);
                    
                    intensities[node.idx] = node.cost;
                    visited[node.idx] = true;
                    pq.add(new Node(node.idx, node.cost));
                } else {
                    if (intensities[node.idx] == Integer.MIN_VALUE) {
                        System.out.println("intensity : " + intensities[node.idx] + " " + Math.max(intensities[current.idx], node.cost));
                        intensities[node.idx] = Math.max(intensities[current.idx], node.cost);
                        pq.add(new Node(node.idx, Math.max(intensities[current.idx], node.cost)));
                        visited[node.idx] = true;
                        
                    } else {
                        if (intensities[node.idx] > node.cost) {
                            System.out.println("intensity : " + intensities[node.idx] + " " + node.cost);
                            intensities[node.idx] = node.cost;
                            pq.add(new Node(node.idx, node.cost));
                            visited[node.idx] = true;
                            
                        }
                    }
                        
                        

                }
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