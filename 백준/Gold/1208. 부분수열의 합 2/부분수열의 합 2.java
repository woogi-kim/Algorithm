import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, s;
    public static long ans;
    public static ArrayList<Integer> leftList = new ArrayList<>();
    public static ArrayList<Integer> rightList = new ArrayList<>();
    public static int[] input;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        s = Integer.parseInt(tmp[1]);
        input = new int[n];
        tmp = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(tmp[i]);
        }

        dfs(0, n / 2, 0, leftList);
        dfs(n / 2, n, 0, rightList);
        Collections.sort(leftList);
        Collections.sort(rightList);
//        for (Integer integer : left) {
//            System.out.println("left.get(i) = " + integer);
//        }
//        for(Integer integer :right){
//            System.out.println("integer = " + integer);
//        }
        int left = 0;
        int right = rightList.size() - 1;
        while (left < leftList.size() && right >= 0) {
            int leftVal = leftList.get(left);
            int rightVal = rightList.get(right);
            if (leftVal + rightVal == s) {
                long leftCount = 0;
                long rightCount = 0;
                while (left < leftList.size() && leftList.get(left) == leftVal) {
                    left++;
                    leftCount++;
                }
                while (right >= 0 && rightList.get(right) == rightVal) {
                    right--;
                    rightCount++;
                }
                ans += leftCount * rightCount;
            }
            if (leftVal + rightVal > s) {
                right--;
            }
            if (leftVal + rightVal < s) {
                left++;
            }
        }
        if (s == 0) {
            ans--;
        }
        System.out.println(ans);
    }

    public static void dfs(int start, int end, int sum, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        dfs(start + 1, end, sum + input[start], list);
        dfs(start + 1, end, sum, list);

    }

}

