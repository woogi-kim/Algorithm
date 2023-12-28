import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        System.out.println(getLarge(input));
        System.out.println(getSmall(input));
    }

    public static String getSmall(String input) {
        StringBuilder small = new StringBuilder();
        int countM = 0;
        int countK = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'M') {
                for (int j = 0; j < countK; j++) {
                    small.append('5');
                }
                countK = 0;
                countM++;
            } else {
                if (countM != 0) {
                    small.append('1');
                    for (int j = 0; j < countM - 1; j++) {
                        small.append('0');
                    }
                }
                countM = 0;
                countK++;
            }
        }
        if (countM != 0) {
            small.append('1');
            for (int i = 0; i < countM - 1; i++) {
                small.append('0');
            }
        }
        if (countK != 0) {
            for (int i = 0; i < countK; i++) {
                small.append('5');
            }
        }
        return small.toString();
    }

    public static String getLarge(String input) {
        StringBuilder largest = new StringBuilder();
        int countM = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'M') {
                countM++;
            } else {
                largest.append("5");
                if (countM >= 1) {
                    for (int j = 0; j < countM; j++) {
                        largest.append("0");
                    }
                }
                countM = 0;
            }

        }
        if (countM != 0) {
            for (int j = 0; j < countM; j++) {
                largest.append("1");
            }
        }
        return largest.toString();
    }
}