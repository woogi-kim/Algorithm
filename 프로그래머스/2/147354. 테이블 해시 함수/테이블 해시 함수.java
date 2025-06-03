import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            } else {
                return o1[col - 1] - o2[col - 1];
            }    
        });
        
        int[] si = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                si[i] += (data[i][j] % (i + 1));
            }
        }
    
        int answer = si[row_begin - 1];
        for (int i = row_begin; i <= row_end - 1; i++) {
            answer ^= si[i];
        }
        
        return answer;
    }
}