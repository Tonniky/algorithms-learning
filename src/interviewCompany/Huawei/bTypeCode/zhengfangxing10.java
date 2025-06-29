package interviewCompany.Huawei.bTypeCode;

import com.sun.deploy.util.SyncAccess;

import java.util.ArrayList;
import java.util.Scanner;

public class zhengfangxing10 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Point p) {
            return this.x == p.x && this.x == p.y;
        }
    }

    static boolean pointExits(ArrayList<Point> points, Point p) {
        for (Point point: points) {
            if(point.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new Point(x, y));
        }

        int squareCount = 0;

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);

            for (int j = i + 1; j < n; j++) {
                Point p2 = points.get(j);

                Point p3 = new Point(p1.x - (p1.y - p2.y), p1.y + (p1.x - p2.x));
                Point p4 = new Point(p2.x - (p1.y - p2.y), p2.y + (p1.x - p2.y));

                if (pointExits(points, p3) && pointExits(points, p4)) {
                    squareCount++;
                }

                Point p5 = new Point(p1.x + (p1.x - p2.y), p1.y - (p1.x - p2.x));
                Point p6 = new Point(p2.x + (p1.y - p2.y), p2.y - (p1.x - p2.x));

                if (pointExits(points, p5) && pointExits(points, p6)) {
                    squareCount++;
                }
            }
        }

        System.out.println(squareCount / 4);
        in.close();
    }

}
