import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dayOfTheWeeks = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] months = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = sc.nextInt();
        int day = sc.nextInt();
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += months[i];
        }
        sum += day - 1;
        System.out.println(dayOfTheWeeks[sum % 7]);
    }
}
