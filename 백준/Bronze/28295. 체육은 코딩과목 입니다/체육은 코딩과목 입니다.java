import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] direction = {"N", "E", "S", "W"};
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        for (int i = 0; i < 10; i++) {
            String order = bufferedReader.readLine();
            switch (order) {
                case "1":
                    index++;
                    break;
                case "2":
                    index += 2;
                    break;
                case "3":
                    index--;
                    break;
            }
        }

        index %= 4;
        if (index < 0) {
            index = 4 + index;
        }
        System.out.println(direction[index]);
    }

}
