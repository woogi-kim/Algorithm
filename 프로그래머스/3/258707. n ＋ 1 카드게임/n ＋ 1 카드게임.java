class Solution {
    public static boolean[] mycard;
    public static boolean[] tmpcard;
    public static int pair;
    public static int tmppair;
    public static int round = 1;
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        
        mycard = new boolean[cards.length + 1];
        tmpcard = new boolean[cards.length + 1];
        
        for (int i = 0; i < n / 3; i++) {
            mycard[cards[i]] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            if (mycard[i] && mycard[n + 1 - i]){
                pair++;
            }
        }
        pair /= 2;
        
        System.out.println(pair + " pair");
        for (int i = n / 3; i < n; i += 2) {
            System.out.println(i + "번째");
            int card1 = cards[i];
            int card2 = cards[i + 1];
            
            if (mycard[n + 1 - card1] && coin > 0) {
                pair++;
                coin--;
                System.out.println(n + 1 - card1 + "랑 매치");
                System.out.println(card1 + "구매");
            }
            if (mycard[n + 1 - card2] && coin > 0) {
                pair++;
                coin--;
                System.out.println(n + 1 - card2 + "랑 매치");
                System.out.println(card2 + "구매");
            }
            
            if (tmpcard[n + 1 - card1]) {
                tmppair++;
            } else {
                tmpcard[card1] = true;
            }
            
            if (tmpcard[n + 1 - card2]) {
                tmppair++;
            } else {
                tmpcard[card2] = true;
            }
            
            System.out.println("pair" + pair + ", coin " + coin + ", tmppair " + tmppair);
            if (pair == 0 && coin >= 2 && tmppair > 0) {
                coin -=2;
                tmppair--;
                pair++;
            }
            
            
            
            if (pair == 0) {
                System.out.println(round + "turn");
                return round;
            }
            
            pair--;
            round++;
        }
        
        
    
        return round;
    }
}