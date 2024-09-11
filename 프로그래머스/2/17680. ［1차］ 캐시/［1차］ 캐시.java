import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        HashSet<String> cache = new HashSet<>();
        HashMap<String,Integer> used = new HashMap<>();
        
        for (int i = 0; i < cities.length; i++) {
            String currentCity = cities[i].toLowerCase();
            
            if (cache.contains(currentCity)) {
                answer++;
                used.put(currentCity, i);
            } else {
                if (cache.size() >= cacheSize) {
                    String evictedCity = getLeastRecentlyUsedCity(used);
                    
                    cache.remove(evictedCity);
                    used.remove(evictedCity);
                }
                
                if (cache.size() < cacheSize) {
                    cache.add(currentCity);
                    used.put(currentCity, i);
                }

                answer += 5;
            }
            
        }
        
        return answer;
    }
    
    public String getLeastRecentlyUsedCity(HashMap<String,Integer> used) {
        int lastUsedTime = Integer.MAX_VALUE;
        String lastUsedCity = "";
        
        for (String city : used.keySet()) {
            if (used.get(city) < lastUsedTime) {
                lastUsedTime = used.get(city);
                lastUsedCity = city;
            }
        }
        
        return lastUsedCity;
    }
    
}