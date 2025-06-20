class Solution {
    public long solution(int[] sequence) {
        int N = sequence.length;
        long answer = 0;
        
        // sequence에 [-1, 1, -1, ...] 형태의 펄스 수열을 곱한 연속 펄스 수열
        int[] sequence1 = new int[N];
        for(int i = 0; i < N; i++) {
            if(i % 2 == 0) {
                sequence1[i] = -sequence[i];
            } else {
                sequence1[i] = sequence[i];
            }
        }
        
        // sequence에 [1, -1, 1, ...] 형태의 펄스 수열을 곱한 연속 펄스 수열
        int[] sequence2 = new int[N];
        for(int i = 0; i < N; i++) {
            if(i % 2 == 1) {
                sequence2[i] = -sequence[i];
            } else {
                sequence2[i] = sequence[i];
            }
        }
        
        long total = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(total >= 0 && R < N) {
                total += sequence1[R];
                answer = Math.max(total, answer);
                R++;
            }
            total -= sequence1[L];
        }
        
        total = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(total >= 0 && R < N) {
                total += sequence2[R];
                answer = Math.max(total, answer);
                R++;
            }
            total -= sequence2[L];
        }
        
        return answer;
    }
}