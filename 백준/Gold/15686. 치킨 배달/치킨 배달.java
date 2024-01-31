
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static int m;
    public static int[][] chickenDistance;
    public static ArrayList<Coord> home = new ArrayList<Coord>();

    public static ArrayList<Coord> chicken = new ArrayList<Coord>();
    public static boolean[] choose;
    public static int ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);


        for (int i = 0; i < n; i++) {
            s = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(s[j]);
                if (tmp == 1) {
                    home.add(new Coord(i, j));
                } else if (tmp == 2) {
                    chicken.add(new Coord(i, j));
                }
            }
        }


        chickenDistance = new int[home.size()][chicken.size()];

        for (int i = 0; i < home.size(); i++) {
            for (int j = 0; j < chicken.size(); j++) {
                Coord coord1 = home.get(i);
                Coord coord2 = chicken.get(j);
                chickenDistance[i][j] = Math.abs(coord1.x - coord2.x) + Math.abs(coord1.y - coord2.y);
            }
        }
        
        choose = new boolean[chicken.size()];

        backtracking(0, m, 0);

        System.out.println(ans);
    }

    public static void backtracking(int depth, int target, int start) {
        if (target == depth) {
            int sumChickenDistance = 0;
            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (choose[j]) {
                        tmp = Math.min(chickenDistance[i][j], tmp);
                    }
                }
                sumChickenDistance += tmp;
            }
            ans = Math.min(sumChickenDistance, ans);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            choose[i] = true;
            backtracking(depth + 1, target, i + 1);
            choose[i] = false;
        }
    }
}




