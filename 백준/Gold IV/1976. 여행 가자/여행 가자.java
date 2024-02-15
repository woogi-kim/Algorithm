import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static boolean[] isVisited;
    public static int[] visitCity;
    public static ArrayList<Integer>[] adjList;
    public static ArrayList<HashSet<Integer>> setList;
    public static boolean canTravel = true;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        adjList = new ArrayList[n];
        isVisited = new boolean[n];
        visitCity = new int[m];
        setList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (s[j].equals("1")) {
                    adjList[i].add(j);
                }
            }
        }

        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            visitCity[i] = Integer.parseInt(s[i]) - 1;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                HashSet<Integer> set = new HashSet<>();
                bfs(i, set);
                setList.add(set);
            }
        }

        HashSet<Integer> fisrtCitySet = null;
        for (HashSet<Integer> set : setList) {
            if (set.contains(visitCity[0])) {
                fisrtCitySet = set;
            }
        }

        for (int i = 1; i < m; i++) {
            if (!fisrtCitySet.contains(visitCity[i])) {
                canTravel = false;
                break;
            }
        }
        System.out.println(canTravel ? "YES" : "NO");

    }

    public static void bfs(int start, HashSet<Integer> set) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        set.add(start);
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int neighbor : adjList[current]) {
                if (!isVisited[neighbor]) {
                    set.add(neighbor);
                    q.add(neighbor);
                    isVisited[neighbor] = true;
                }
            }
        }
    }

}




