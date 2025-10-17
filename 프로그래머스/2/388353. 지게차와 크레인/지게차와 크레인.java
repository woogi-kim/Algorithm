import java.util.*;

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x =x;
        this.y = y;
    }
}

class Solution {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0, 1, 0, -1};
    
    public static char[][] map;
    public static int n, m;
    
    public int solution(String[] storage, String[] requests) {
        this.n = storage.length;
        this.m = storage[0].length();
        
        map = new char[n + 2][m + 2];
        
        for (int i = 0; i <= n + 1; i++) {
            Arrays.fill(map[i], '0');
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        
        for (String command : requests) {       
            if (command.length() == 1) {
                forklift(command.charAt(0));
            } else {
                crain(command.charAt(0));
            }
            
            // System.out.println("----------");
            // for (int i = 0; i <= n + 1; i++) {
            //     System.out.println(Arrays.toString(map[i]));
            // }    
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '0') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public static void forklift(char target) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 2][m + 2];
        
        q.add(new Point(0, 0));
        visited[0][0] = true;
        ArrayList<Point> result = new ArrayList<>();
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            // System.out.println(cur.x + " " + cur.y);
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                    
                if (!(nx >= 0 && nx <= n + 1 && ny >= 0 && ny <= m + 1)) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (map[nx][ny] != '0') {
                    continue;
                }
                
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
                
                for (int j = 0; j < 4; j++) {
                    int nnx = nx + dx[j];
                    int nny = ny + dy[j];
                    
                    // System.out.println(cur.x + " " + cur.y + " 후보 확인");
                    if (!(nnx >= 0 && nnx <= n + 1 && nny >= 0 && nny <= m + 1)) {
                        continue; 
                    }
                    
                    if (map[nnx][nny] == target) {
                        result.add(new Point(nnx, nny));
                    }
                }
            }
        }
        
        for (Point p : result) {
            map[p.x][p.y] = '0';
        }
    }
    
    public static void crain(char target) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == target) {
                    map[i][j] = '0';
                }
            }
        }
    }
}