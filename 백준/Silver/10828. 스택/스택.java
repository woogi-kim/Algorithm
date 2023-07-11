import java.io.*;
import java.sql.Statement;
import java.util.*;

public class Main {
    public static int[] stack = new int[10001];

    public static int size = 0;
    public static int N;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(bufferedReader.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
                switch (st.nextToken()) {
                    case "push":
                        push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        sb.append(pop()).append("\n");
                        break;
                    case "size":
                        sb.append(size()).append("\n");
                        break;
                    case "empty":
                        sb.append(empty()).append("\n");
                        break;
                    case "top":
                        sb.append(top()).append("\n");
                        break;
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void push(int x) {
        stack[size] = x;
        size++;
    }

    public static int pop() {
        if (size == 0)
            return -1;
        else {
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0)
            return 1;
        else
            return 0;
    }

    public static int top() {
        if (size == 0)
            return -1;
        else
            return stack[size - 1];
    }
}