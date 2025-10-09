import java.util.*;

class Solution {
    public static int[] parents;
    public static String[] cells;
    public static List<String> result;
    
    public static int find(int x) {
        if (x == parents[x]) {
            return parents[x];
        }
        
        return parents[x] = find(parents[x]);
    }
    
    public static void union (int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) {
            if (cells[x] == null) {
                cells[x] = cells[y];
            } 
            cells[y] = null;
            
            parents[y] = x;
        }
    }
    
    
    public String[] solution(String[] commands) {
        result = new ArrayList<>();
        cells = new String[2501];
        parents = new int[2501];
        
        for (int i = 1; i < 2501; i++) {
            parents[i] = i;
        }
        
        for (String command : commands) {
            String[] elements = command.split(" ");
            if (elements[0].equals("UPDATE")) {
                if (elements.length == 4) {
                    updateRC(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[3]);
                } else {
                    updateValue(elements[1], elements[2]);
                }
            } else if (elements[0].equals("MERGE"))  {
                merge(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), 
                     Integer.parseInt(elements[3]), Integer.parseInt(elements[4]));
            } else if (elements[0].equals("UNMERGE")) {
                unmerge(Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
            } else {
                String val = cells[find(getIndex(Integer.parseInt(elements[1]), Integer.parseInt(elements[2])))];
                if (val == null) {
                    result.add("EMPTY");    
                } else {
                    result.add(val);
                }
                
            }
        }
        
        
        return result.toArray(new String[0]);
    }
    public static int getIndex(int r, int c) {
        return (r  - 1)* 50 + c;
    }
    
    public static void updateRC(int r, int c , String value) {
        int parent = find(getIndex(r, c));
        
        cells[parent] = value;
    }
    
    public static void updateValue(String val1, String val2) {
        // System.out.println(cells[1].equals("d"));
        for (int i = 1; i < 2501; i++) {
            if (val1.equals(cells[i])) {
                cells[i] = val2;
            }
        }
    }
    
    public static void merge(int r1, int c1, int r2, int c2) {
        union(getIndex(r1, c1), getIndex(r2, c2));
    }
    
    public static void unmerge(int r, int c) {
        for (int i = 1; i < 2501; i++) {
            find(i);
        }
        
        int parent = parents[getIndex(r, c)];
        String value = cells[parent];
        
        for (int i = 1; i < 2501; i++) {
            if (parent == parents[i]) {
                parents[i] = i;
                cells[i] = null;
            }
        }
        
        cells[getIndex(r, c)] = value;
    }
}