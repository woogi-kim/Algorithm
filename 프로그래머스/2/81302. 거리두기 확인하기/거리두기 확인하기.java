import java.util.*;

//             for(int j = 0; j < places[i].length; j++) {
//                 System.out.println(places[i][j]);
//             }
//                 System.out.println();
class Solution {
    public char[][] room;
    
    public int[] solution(String[][] places) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for (int roomNum = 0; roomNum < 5; roomNum++) {
            room = new char[5][5];
            
            for (int i = 0; i < 5; i++) {
                room[i] = places[roomNum][i].toCharArray();
            }
            
            answerList.add(searchRoom(room));
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public int searchRoom(char[][] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i][j] == 'P') {
                    System.out.println(i +" "+ j);
                    if (!isAway(i, j, room)) {
                        return 0;
                    }
                }
            }
        }
        
        return 1;
    }
    
    public boolean isAway(int startX, int startY, char[][] room) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        boolean[][] visited = new boolean[5][5];
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(startX, startY));
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.println("current : " + current.x + " " + current.y);
            for(int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                System.out.println("new : " + newX + " " + newY);
                
                if (!(newX >= 0 && newX < 5 && newY >= 0 && newY < 5)) {
                    continue;
                } 
                
                if ((Math.abs(newX - startX) + Math.abs(newY - startY)) > 2) {
                    continue;
                }
                
                if (visited[newX][newY]) {
                    continue;
                }
                
                if (room[newX][newY] == 'X') {
                    continue;
                } else if (room[newX][newY] == 'O') {
                    q.add(new Node(newX, newY));
                    visited[newX][newY] = true;
                } else {
                    return false;
                }    
            }
        }
        
        // System.out.println(visited);
        return true;
    }
}

class Node {
    int x;
    int y;
    
    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}