import java.io.*;
import java.sql.Statement;
import java.util.*;

public class Main {
    public static int N;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            N = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                String ps = bufferedReader.readLine();
                Stack<String> stack = new Stack<>();
                int cp = 0;
                for (int j = 0; j < ps.length(); j++) {
                    if (ps.charAt(j) == '(')
                        stack.push(String.valueOf(ps.charAt(j)));
                    else {
                        cp++;
                        if (!stack.isEmpty()) {
                            stack.pop();
                            cp--;
                        }
                    }
                }
                if (stack.isEmpty() && cp == 0)
                    sb.append("YES").append("\n");
                else
                    sb.append("NO").append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}