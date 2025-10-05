import java.util.*;

class Node {
    int idx;
    int amount;
    
    public Node (int idx, int amount) {
        this.idx = idx;
        this.amount = amount;
    }
}

class Solution {
    public static PriorityQueue<Node> delivery;
    public static PriorityQueue<Node> pickup;
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        delivery = new PriorityQueue<>((o1, o2) -> o2.idx - o1.idx);
        pickup = new PriorityQueue<>((o1, o2) -> o2.idx - o1.idx);
        
        for (int i = 0; i < n; i++) {
            delivery.add(new Node(i + 1, deliveries[i]));
            pickup.add(new Node(i + 1, pickups[i]));
        }    
        
        long answer = 0;
        
        while (!delivery.isEmpty() || !pickup.isEmpty()) {
            while (!delivery.isEmpty() && delivery.peek().amount == 0) {
                delivery.poll();
            }
            while (!pickup.isEmpty() && pickup.peek().amount == 0) {
                pickup.poll();
            }
            int maxMove = delivery.isEmpty() ? 0 : delivery.peek().idx;
            maxMove = Math.max(pickup.isEmpty() ? 0 : pickup.peek().idx, maxMove);
            // System.out.println("total = "  + maxMove);
            
            int totalAmount = 0;
            while (!delivery.isEmpty()) {
                if (totalAmount + delivery.peek().amount > cap) {
                    Node cur = delivery.poll();
                    delivery.add(new Node(cur.idx, cur.amount - (cap - totalAmount)));
                    
                    break;
                } 
                // System.out.println("배달 idx = "  + delivery.peek().idx);
                totalAmount += delivery.poll().amount;
            }
            
            totalAmount = 0;
            while (!pickup.isEmpty()) {
                if (totalAmount + pickup.peek().amount > cap) {
                    Node cur = pickup.poll();
                    pickup.add(new Node(cur.idx, cur.amount - (cap - totalAmount)));
                    
                    break;
                } 
                // System.out.println("픽업 idx = "  + pickup.peek().idx);
                totalAmount += pickup.poll().amount;
            }
            
            answer += maxMove;
        }
        
        return (long) 2 * answer;
    }
}