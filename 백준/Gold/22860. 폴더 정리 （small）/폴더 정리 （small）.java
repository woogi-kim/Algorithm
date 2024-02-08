import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Folder {
    String name;
    int idx;
    ArrayList<String> files;
    ArrayList<Integer> childIdx;

    public Folder() {
        this.files = new ArrayList<>();
        this.childIdx = new ArrayList<>();
    }

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.childIdx = new ArrayList<>();
    }
}

public class Main {
    public static int n;
    public static int m;
    public static int q;
    public static String[][] input;
    public static Folder[] folders;
    public static int emptyIdx;
    public static StringBuilder sb;
    public static HashSet<String> set;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        sb = new StringBuilder();

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        input = new String[n + m][3];
        folders = new Folder[n + 1];

        for (int i = 0; i < n + 1; i++) {
            folders[i] = new Folder();
        }

        folders[0].name = "main";
        folders[0].idx = 0;

        emptyIdx = 1;

        for (int i = 0; i < n + m; i++) {
            s = bf.readLine().split(" ");
            input[i][0] = s[0];
            input[i][1] = s[1];
            input[i][2] = s[2];
        }
        insert("main", 0);

        q = Integer.parseInt(bf.readLine());
        for (int i = 0; i < q; i++) {
            s = bf.readLine().split("/");
            String start = s[s.length - 1];
            for (int j = 0; j < n + 1; j++) {
                if (start.equals(folders[j].name)) {
                    set = new HashSet<>();
                    count = 0;
                    search(j);
                    sb.append(set.size()).append(' ').append(count);
                    sb.append('\n');
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void search(int idx) {
        for(String s : folders[idx].files){
            set.add(s);
            count++;
        }
        for (int i : folders[idx].childIdx) {
            search(i);
        }
    }


    public static void insert(String name, int currentIdx) {
        if (currentIdx > n) {
            return;
        }
        for (int i = 0; i < n + m; i++) {
            if (input[i][0].equals(name)) {
                if (input[i][2].equals("1")) {
                    folders[emptyIdx].name = input[i][1];
                    folders[emptyIdx].idx = emptyIdx;
                    folders[currentIdx].childIdx.add(emptyIdx);
                    int nextIdx = emptyIdx;
                    emptyIdx++;
                    insert(input[i][1], nextIdx);
                } else {
                    folders[currentIdx].files.add(input[i][1]);
                }
            }
        }
    }
}




