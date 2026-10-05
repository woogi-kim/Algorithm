class Solution {
    public static int n, m;
    public static int[][] sum;
    public int solution(int[][] board, int[][] skill) {
        n = board.length;
        m = board[0].length;
        
        sum = new int[n + 1][m + 1];
        
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = type == 1 ? -1 * skill[i][5] : skill[i][5];
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] += -1 * degree;
            sum[r2 + 1][c1] += -1 * degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                sum[i + 1][j] += sum[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                sum[j][i + 1] += sum[j][i];
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += sum[i][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}