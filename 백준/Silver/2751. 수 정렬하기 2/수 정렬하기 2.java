import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int n;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            n = Integer.parseInt(bufferedReader.readLine());
            ArrayList<Integer> input = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                input.add(Integer.parseInt(bufferedReader.readLine()));
            }
            Collections.sort(input);
            for(int i : input)
                sb.append(i+"\n");
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}