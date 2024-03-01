import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int[] rightIdx = new int[51];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        for (int i = 0; i < input.length; i++) {
            String value = input[i];
            if (value.equals("(")) stack.add(i);
            if (value.equals(")")) rightIdx[stack.pop()] = i;
        }

        System.out.println(solve( input, 0, input.length));
    }

    public static int solve(String[] arr, int start, int end) {
        int length = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++) {
            sb.append(arr[i]);
        }
        for (int i = start; i < end; i++) {
            if (arr[i].equals("(")) {
                length += Integer.parseInt(arr[i - 1]) * solve(arr, i + 1, rightIdx[i]) - 1;
                i = rightIdx[i];
            } else {
                length++;
            }
        }

        return length;
    }

}




