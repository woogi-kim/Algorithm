// i번째 로우에선 i가 i번... 그다음 하나씩
class Solution {
    public static int[] result;
    public int[] solution(int n, long left, long right) {
        result = new int[(int) (right - left + 1)];
        
        for (long i = left; i <= right; i++) {
            int row = (int) (i / n);
            int column = (int) (i % n);
            
            if (column <= row) {
                result[(int) (i - left)] = row;
            } else {
                result[(int) (i - left)] = column;
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            result[i]++;
        }
        
        return result;
    }
}