import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int x;
    public static int y;
    public static int t;
    public static int d;
    public static double totalDistance;
    public static double onlyWalkTime;
    public static double onlyJumpTime;
    public static double jumpWalkTime;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        x = Integer.parseInt(s[0]);
        y = Integer.parseInt(s[1]);
        d = Integer.parseInt(s[2]);
        t = Integer.parseInt(s[3]);

        totalDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        onlyWalkTime = totalDistance;

        double currentDistance = 0;

        int currentTime = 0;
        while (currentDistance < totalDistance) {
            currentDistance += d;
            onlyJumpTime += t;
            currentTime += t;
        }

        if (onlyJumpTime == t) {
            onlyJumpTime += t;
        }

        double overDistance = currentDistance;
        double overJumpWalkTime = currentTime + (overDistance - totalDistance);
        double lessJumpWalkTime = (currentTime - t) + (totalDistance - (overDistance - d));
        jumpWalkTime = Math.min(overJumpWalkTime, lessJumpWalkTime);

        System.out.println(Math.min(jumpWalkTime, Math.min(onlyWalkTime, onlyJumpTime)));
    }
}