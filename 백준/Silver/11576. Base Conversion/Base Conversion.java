import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            String[] input = bf.readLine().split(" ");
            int baseA = Integer.parseInt(input[0]);
            int baseB = Integer.parseInt(input[1]);
            int n = Integer.parseInt(bf.readLine());

            input = bf.readLine().split(" ");

            int decimal = 0;
            int square = 1;
            for (int i = n - 1; i >= 0; i--) {
                decimal += square * Integer.parseInt(input[i]);
                square *= baseA;
            }

            if (decimal == 0) {
                sb.append(0);
            }

            Stack<Integer> stack = new Stack<>();

            while (decimal != 0) {
                stack.push(decimal % baseB);
                decimal /= baseB;
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}