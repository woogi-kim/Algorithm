import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static int t;
    public static int n;
    public static int[] parentArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            parentArr = new int[n + 1];
            for (int j = 0; j < n - 1; j++) {
                st = new StringTokenizer(bf.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                parentArr[child] = parent;
            }
            int root = 0;
            for (int j = 1; j <= n; j++) {
                if (parentArr[j] == 0) {
                    root = j;
                    break;
                }
            }

            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            ArrayList<Integer> firstParent = new ArrayList<>();
            ArrayList<Integer> secondParent = new ArrayList<>();
            int tmp = first;
            firstParent.add(tmp);
            while (true) {
                if (tmp == root) {
                    break;
                }
                firstParent.add(parentArr[tmp]);
                tmp = parentArr[tmp];

            }
            tmp = second;
            secondParent.add(tmp);
            while (true) {
                if (tmp == root) {
                    break;
                }
                secondParent.add(parentArr[tmp]);
                tmp = parentArr[tmp];

            }

            for (int k : firstParent) {
                if (secondParent.contains(k)) {
                    System.out.println(k);
                    break;
                }
            }
        }

    }


}

