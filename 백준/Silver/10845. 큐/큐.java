import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int front = -1;
    public static int rear = 0;
    public static int queue[] = new int[10001];

    public static void push(int x) {
        queue[rear] = x;
        rear++;
    }

    public static int pop() {
        if (empty() == 1)
            return -1;
        else {
            front++;
            return queue[front];
        }
    }

    public static int size() {
        return rear - front - 1;
    }

    public static int empty() {
        if (size() == 0)
            return 1;
        else
            return 0;
    }

    public static int front() {
        if (empty() == 1) {
            return -1;
        } else {
            return queue[front + 1];
        }
    }

    public static int back() {
        if (empty() == 1) {
            return -1;
        } else {
            return queue[rear - 1];
        }
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(bufferedReader.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                switch (st.nextToken()) {
                    case "push":
                        push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        sb.append(pop()).append('\n');
                        break;
                    case "size":
                        sb.append(size()).append('\n');
                        break;
                    case "empty":
                        sb.append(empty()).append('\n');
                        break;
                    case "front":
                        sb.append(front()).append('\n');
                        break;
                    case "back":
                        sb.append(back()).append('\n');
                        break;
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}