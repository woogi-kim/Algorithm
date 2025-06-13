import java.util.*;

// 처음엔 결국 버스 도착 시간들중 하나가 답 아닐까? 생각함.
// 어차피 가장 늦게 가야한다면, 딱코로 가는게 이득이니까

// 근데 예제 3번같이, 이미 대기열이 버스를 다 탄다면 그 대기열보다 빨리 도착해야함.

// 일단 timetable들을 각각 버스에 넣어보고
// 만약, 빈자리가 있다면,그 빈자리 있는 버스 도착시간에 넣어버리고
// 빈자리가 없다면? 버스 도착시간과 버스 도착 1분전을 검사해야하나?

class TimeTable {
    int hour;
    int min;
    
    TimeTable (int hour, int min) {
        this.hour = hour;
        this.min = min;
    }
}

class Crew {
    TimeTable timeTable;
    int isCorn;
    
    Crew (TimeTable timeTable, int isCorn) {
        this.timeTable = timeTable;
        this.isCorn = isCorn;
    }
}

class Solution {
    public static ArrayList<TimeTable> busArriveTimes;
    public static int maxTime;
    
    public String solution(int n, int t, int m, String[] timetable) {
        busArriveTimes = new ArrayList<>();
        
        int busArriveTime = 9 * 60;
        busArriveTimes.add(new TimeTable(9, 0));
        for (int i = 0; i < n - 1; i++) {
            busArriveTime += t;
            busArriveTimes.add(new TimeTable(busArriveTime / 60, busArriveTime % 60));
        }
        
        for (int i = 0; i <= 24 * 60 - 1; i++) {
            ArrayList<Crew> crews = new ArrayList<>();
            crews.add(new Crew(new TimeTable(i / 60, i % 60), 1));
            
            for (String s : timetable) {
                String[] ss = s.split(":");
                crews.add(new Crew(new TimeTable(Integer.valueOf(ss[0]), Integer.valueOf(ss[1])), 0));
            }
            
            Collections.sort(crews, (a,b) -> {
                if (a.timeTable.hour == b.timeTable.hour) {
                    if (a.timeTable.min == b.timeTable.min) {
                        return a.isCorn - b.isCorn;
                    } else {
                        return a.timeTable.min - b.timeTable.min;
                    }
                } else {
                    return a.timeTable.hour - b.timeTable.hour;
                }
            });
            
            int lastPassengerIdx = 0;
            
            int firstBusArriveTime = 9 * 60;
            int lastBusArriveTime = 9 * 60;
            boolean isCornTaked = false;
            int cornTime = 0;
            for (int j = 0; j < n; j++) {
                if (lastPassengerIdx >= crews.size()) {
                        break;
                }
                lastBusArriveTime = firstBusArriveTime + (t * j);
                int curPassengerCount = 0;
                while (curPassengerCount < m) {
                    if (lastPassengerIdx >= crews.size()) {
                        break;
                    }
                    int curPassengerTime = crews.get(lastPassengerIdx).timeTable.hour * 60 + crews.get(lastPassengerIdx).timeTable.min;
                    
                    if (curPassengerTime > lastBusArriveTime) {
                        break;
                    }
                    if (crews.get(lastPassengerIdx).isCorn == 1) {
                        isCornTaked = true;
                        cornTime = curPassengerTime;
                    }
                    curPassengerCount++;
                    lastPassengerIdx++;
                }
            }            
            
            if (isCornTaked) {
                maxTime = Math.max(maxTime, cornTime);
            }
        }        
        
        int h = maxTime / 60;
        int mm = maxTime % 60;
        
        StringBuilder sb = new StringBuilder();
        if (h >= 0 && h < 10) {
            sb.append('0');
        }
        sb.append(h);
        sb.append(':');
        if (mm >= 0 && mm < 10) {
            sb.append('0');
        }
        sb.append(mm);
        return sb.toString();
    }
}