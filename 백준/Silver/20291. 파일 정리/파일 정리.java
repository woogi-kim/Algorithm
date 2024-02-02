
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static StringBuilder sb= new StringBuilder();
    public static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split("\\.");
            String ext = s[1];
            if (!map.containsKey(ext)) {
                map.put(ext, 1);
            } else {
                map.put(ext, map.get(ext) + 1);
            }
        }

        ArrayList<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);
        for (String s : keys) {
            sb.append(s).append(' ').append(map.get(s)).append('\n');
        }
        System.out.println(sb.toString());
    }


}




