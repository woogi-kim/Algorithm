import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    char[][] coins;
    int num;

    public Node(char[][] coins, int num) {
        this.coins = coins;
        this.num = num;
    }
}

public class Main {
    public static int n;
    public static char[][] input;
    public static HashSet<String> isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            input = new char[3][3];
            isVisited = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                char[] chars = bf.readLine().toCharArray();
                input[j][0] = chars[0];
                input[j][1] = chars[2];
                input[j][2] = chars[4];
            }

//            for (int j = 0; j < 3; j++) {
//                for (int k = 0; k < 3; k++) {
//                    System.out.print(input[j][k]+" ");
//                }
//                System.out.println();
//            }
            solve(input);
        }
    }

    public static void solve(char[][] start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        isVisited.add(arrToString(start));
        while (!q.isEmpty()) {
            char[][] newArr = new char[3][3];
            Node current = q.poll();
            if (isSameFace(current.coins)) {
                System.out.println(current.num);
                return;
            }
            for (int i = 0; i < 8; i++) {
                newArr = new char[3][3];
                deepCopy(current.coins, newArr);
                if (i < 3) {
                    for (int j = 0; j < 3; j++) {
                        newArr[i][j] = newArr[i][j] == 'T' ? 'H' : 'T';
                    }
                } else if (i < 6) {
                    for (int j = 0; j < 3; j++) {
                        newArr[j][i % 3] = newArr[j][i % 3] == 'T' ? 'H' : 'T';
                    }
                } else if (i == 6) {
                    for (int j = 0; j < 3; j++) {
                        newArr[j][j] = newArr[j][j] == 'T' ? 'H' : 'T';
                    }
                } else {
                    for (int j = 0; j < 3; j++) {
                        newArr[j][2 - j] = newArr[j][2 - j] == 'T' ? 'H' : 'T';
                    }
                }
                String s = arrToString(newArr);
                if(!isVisited.contains(s)){
                    q.add(new Node(newArr, current.num + 1));
                    isVisited.add(arrToString(newArr));
                }
            }
        }
        System.out.println(-1);
    }

    public static String arrToString(char[][] newArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(newArr[i][j]);
            }
        }
        return sb.toString();
    }

    public static boolean isSameFace(char[][] newArr) {
        int hCount = 0;
        int tCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (newArr[i][j] == 'H') {
                    hCount++;
                } else {
                    tCount++;
                }

            }
        }
        return tCount == 9 || hCount == 9;
    }

    public static void deepCopy(char[][] current, char[][] newArr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newArr[i][j] = current[i][j];
            }
        }

    }
}


