import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int countX = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                countX++;
            } else {
                if (countX % 2 == 1) {
                    System.out.println(-1);
                    return;
                } else {
                    while (countX >= 4) {
                        countX -= 4;
                        sb.append("AAAA");
                    }
                    if (countX == 2) {
                        countX -= 2;
                        sb.append("BB");
                    }
                    sb.append('.');
                }
            }
        }
        if (countX % 2 == 1) {
            System.out.println(-1);
            return;
        } else {
            while (countX >= 4) {
                countX -= 4;
                sb.append("AAAA");
            }
            if (countX == 2) {
                countX -= 2;
                sb.append("BB");
            }
        }
        System.out.println(sb);
    }

}
