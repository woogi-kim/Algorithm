import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static char[][] inputBoard = new char[9][9];
    public static ArrayList<Coord> posZero = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String s = bf.readLine();
            for (int j = 0; j < 18; j += 2) {
                inputBoard[i][j / 2] = s.charAt(j);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (inputBoard[i][j] == '0') {
                    posZero.add(new Coord(i, j));
                }
            }
        }

        dfs(0);

    }

    public static void dfs(int idx) {

        if (idx == posZero.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(inputBoard[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);;
        }

        Coord nextZero = posZero.get(idx);
        for (int i = 1; i <= 9; i++) {
            if (isValidBoard(nextZero, (char) ('0' + i))) {
                inputBoard[nextZero.x][nextZero.y] = (char) ('0' + i);
                dfs(idx + 1);
                inputBoard[nextZero.x][nextZero.y] = '0';

            }

        }
    }


    public static boolean isValidBoard(Coord nextZero, char value) {
        for (int i = 0; i < 9; i++) {
            if (inputBoard[nextZero.x][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (inputBoard[i][nextZero.y] == value) {
                return false;
            }
        }

        for (int i = (nextZero.x / 3) * 3; i < ((nextZero.x / 3) * 3) + 3; i++) {
            for (int j = (nextZero.y / 3) * 3; j < ((nextZero.y / 3) * 3) + 3; j++) {
                if (inputBoard[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
