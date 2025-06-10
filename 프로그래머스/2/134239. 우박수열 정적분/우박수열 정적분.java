import java.util.*;

class Solution {
    public ArrayList<Integer> ubak;
    public double[] solution(int k, int[][] ranges) {
        ubak = new ArrayList<>();
        
        while (true) {
            ubak.add(k);
            if (k == 1) {
                break;
            }
            
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k *= 3;
                k++;
            }
        }
        
        for (int i = 0; i < ubak.size(); i++) {
            System.out.println(ubak.get(i));
        }
        
        ArrayList<Double> res = new ArrayList<>();
        
        for (int[] range : ranges) {
            int start = range[0];
            int end = ubak.size() - 1 + range[1];
            System.out.println(start + " " + end);
            if (start > end) {
                res.add(-1.0);
                continue;
            }
            
            double total = 0.0;
            for (int i = start; i < end; i++) {
                total += (double) ((ubak.get(i) + ubak.get(i + 1)) / 2.0);    
            }
            
            res.add(total);
        }
        
        double[] answer = new double[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}