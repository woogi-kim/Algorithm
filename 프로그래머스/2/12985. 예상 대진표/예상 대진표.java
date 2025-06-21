// 이진트리로 볼 수 있음
// 최종 승자를 가리기 위해 log N 라운드가 필요함

// 라운드 마다 참가자 수는 절반으로 줄어든다.
// 라운드마다 매치 수는 참가자 수 / 2이다.

// 아 인덱스를 2로 나눈 리스트를 만들고 걔네끼리 비교해도 좋을듯
import java.util.*;

class Player {
    int originalNum;
    int currentNum;
    
    Player (int originalNum, int currentNum) {
        this.originalNum = originalNum;
        this.currentNum = currentNum;
    }
}

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        Queue<Player> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(new Player(i, i));
        }
        
        int N = n;
        
        int round = 1;
        while (true) {
            if (Math.pow(2, round) > N) {
                break;
            }
            
            for (int i = 1 ; i <= n / 2; i++) {
                // 매치 진행
                Player p1 = q.poll();
                Player p2 = q.poll();
                // 만난다면 종료
                if ((p1.originalNum == a && p2.originalNum == b) || 
                   (p1.originalNum == b && p2.originalNum == a)) {
                    return round;
                }
                
                if (p1.originalNum == a || p2.originalNum == a) {
                    q.add(new Player(a, i));
                } else if (p1.originalNum == b || p2.originalNum == b) {
                    q.add(new Player(b, i));
                } else {
                    q.add(new Player(p1.originalNum, i));
                }
            } 
            
            n /= 2;
            round++;
        }
        
        return -1;
    }
}