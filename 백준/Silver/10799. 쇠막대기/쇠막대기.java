import java.io.*;
import java.sql.Statement;
import java.util.*;

public class Main {
    public static int N;
    public static int count;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = bufferedReader.readLine();
            int numOpen = 0;
            Character previous = null;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    numOpen++;
                    previous = '(';
                } else if (str.charAt(i) == ')' && previous == '(') {
                    numOpen--;
                    count += numOpen;
                    previous = ')';
                } else {
                    count++;
                    numOpen--;
                    previous = ')';
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}