import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] result = new int[4];
        int idx = 0;

        for(int i = 0; i < edges.length; i++) {
            idx = Math.max(idx, Math.max(edges[i][0], edges[i][1]));
        }

        int[] in = new int[idx + 1];
        int[] out = new int[idx + 1];

        for(int i = 0; i < edges.length; i++) {
            out[edges[i][0]]++;
            in[edges[i][1]]++;
        }

        for(int i = 1; i < idx + 1; i++) {
            if(out[i] - in[i] > 1) {
                result[0] = i;
                break;
            }
        }

        for(int i = 1; i < idx + 1; i++) {            
            if(out[i] >= 2 && in[i] >= 2) result[3]++;
            if(out[i] == 0 && in[i] > 0) result[2]++;
        }

        result[1] = out[result[0]] - result[2] - result[3];

        return result;

    }
}
