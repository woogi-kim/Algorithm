import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int jungle;
    int sea;
    int ice;


    public void add(Node node) {
        this.jungle += node.jungle;
        this.sea += node.sea;
        this.ice += node.ice;
    }

    public void sub(Node node) {
        this.jungle -= node.jungle;
        this.sea -= node.sea;
        this.ice -= node.ice;
    }
}

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static Node[][] mapCount;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);

        mapCount = new Node[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                mapCount[i][j] = new Node();
            }
        }

        k = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= m; i++) {
            String tmp = bf.readLine();
            for (int j = 1; j <= n; j++) {

                mapCount[i][j].jungle = mapCount[i - 1][j].jungle + mapCount[i][j - 1].jungle - mapCount[i - 1][j - 1].jungle;
                mapCount[i][j].ice = mapCount[i - 1][j].ice + mapCount[i][j - 1].ice - mapCount[i - 1][j - 1].ice;
                mapCount[i][j].sea = mapCount[i - 1][j].sea + mapCount[i][j - 1].sea - mapCount[i - 1][j - 1].sea;

                switch (tmp.charAt(j - 1)) {
                    case 'J':
                        mapCount[i][j].jungle++;
                        break;
                    case 'O':
                        mapCount[i][j].sea++;
                        break;
                    case 'I':
                        mapCount[i][j].ice++;
                        break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            int d = Integer.parseInt(s[3]);

            int jungle = mapCount[c][d].jungle - mapCount[a - 1][d].jungle - mapCount[c][b - 1].jungle + mapCount[a - 1][b - 1].jungle;
            int sea = mapCount[c][d].sea - mapCount[a - 1][d].sea - mapCount[c][b - 1].sea + mapCount[a - 1][b - 1].sea;
            int ice = mapCount[c][d].ice - mapCount[a - 1][d].ice - mapCount[c][b - 1].ice + mapCount[a - 1][b - 1].ice;
            sb.append(jungle)
                    .append(' ')
                    .append(sea)
                    .append(' ')
                    .append(ice)
                    .append('\n');
        }
        System.out.println(sb);
    }
    
}
