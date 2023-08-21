import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Point a = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        Point b = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        Point c = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        Point d = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

        double low = 0;
        double high = 1000000;
        double p, q;
        double min = 100000000;
        while (high - low >= 1e-6) {
            p = ((2 * low) + high) / 3;
            q = ((2 * high) + low) / 3;
            Point aP = new Point(a.x + (b.x - a.x) * (p / 1000000), a.y + (b.y - a.y) * (p / 1000000));
            Point aQ = new Point(a.x + (b.x - a.x) * (q / 1000000), a.y + (b.y - a.y) * (q / 1000000));
            Point cP = new Point(c.x + (d.x - c.x) * (p / 1000000), c.y + (d.y - c.y) * (p / 1000000));
            Point cQ = new Point(c.x + (d.x - c.x) * (q / 1000000), c.y + (d.y - c.y) * (q / 1000000));

            double dP = getDistance(aP, cP);
            double dQ = getDistance(aQ, cQ);

            if (dP > dQ) {
                low = p;
                min = Math.min(min, dQ);
            } else {
                high = q;
                min = Math.min(min, dP);
            }
        }
        System.out.println(min);
    }
}