class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int cur = 1;
        
        for (int i = 0; i < stations.length; i++) {
            int l = stations[i] - w;
            int r = stations[i] + w;
            if (cur < l) {
                int count = (l - cur) % (2 * w + 1) == 0 ? (l - cur) / (2 * w + 1) : (l - cur) / (2 * w + 1) + 1;
                answer += count;        
            }
            
            cur = r + 1;
        }
        
        if (cur <= n) {
            int count = (n - cur + 1) % (2 * w + 1) == 0 ? (n - cur + 1) / (2 * w + 1) : (n - cur + 1) / (2 * w + 1) + 1;
            answer += count;       
        }

        return answer;
    }
}