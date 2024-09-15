import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        int n = records.length;
        
        HashMap<String, Integer> inTimes = new HashMap<>();
        HashMap<String, Integer> totalTimes = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String[] info = records[i].split(" ");
            
            String[] timeString = info[0].split(":");
            int time = Integer.parseInt(timeString[0]) * 60 + Integer.parseInt(timeString[1]); 
            
            String carNum = info[1];
            
            if (info[2].equals("IN")) {
                inTimes.put(carNum, time);
            } else {
                int inTime = inTimes.get(carNum);
                
                int totalTime = time - inTime;
                
                if (totalTimes.containsKey(carNum)) {
                    totalTimes.put(carNum, totalTime + totalTimes.get(carNum));
                } else {
                    totalTimes.put(carNum, totalTime);
                }
                
                inTimes.remove(carNum);
            }
        }
        
        for (String carNum : inTimes.keySet()) {
            int totalTime = (23 * 60 + 59) - inTimes.get(carNum);
            
            if (totalTimes.containsKey(carNum)) {
                totalTimes.put(carNum, totalTime + totalTimes.get(carNum));
            } else {
                totalTimes.put(carNum, totalTime);
            }
        }
        
        List<Integer> answerList  = new ArrayList<>();
        
        PriorityQueue<String> carNums = new PriorityQueue<>();
        for (String carNum : totalTimes.keySet()) {
            carNums.add(carNum);
        }
        
        while(!carNums.isEmpty()) {
            String carNum = carNums.poll();
            int totalTime = totalTimes.get(carNum);
            
            int currentFee = defaultFee;
            
            if (totalTime > defaultTime) {
                if ((totalTime - defaultTime) % unitTime == 0) {
                    currentFee += ((totalTime - defaultTime) / unitTime) * unitFee;
                } else {
                    currentFee += (((totalTime - defaultTime) / unitTime) + 1) * unitFee;
                }
            }
            
            answerList.add(currentFee);
        }
        
        
        

        return convertListToArray(answerList);
    }
    
    public int[] convertListToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}