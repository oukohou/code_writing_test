package oukohou.fire_and_shoot.meitu;

/**
 * Created by oukohou on 2017/9/4.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class MaxMinArea_luoyifeng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in

        );
        int count = scanner.nextInt();
        while (count != 0) {
            ArrayList<Point> points = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                points.add(new Point(scanner.nextDouble(), scanner.nextDouble()));
            }
            ArrayList<Double> areas = new ArrayList<Double>();
            double max = Integer.MIN_VALUE;
            double min = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                for (int j = i + 1; j < count; j++) {
                    for (int m = j + 1; m < count; m++) {
                        if (max < mianji(points.get(i), points.get(j), points.get(m))) {
                            max = mianji(points.get(i), points.get(j), points.get(m));
                        }
                        if (min > mianji(points.get(i), points.get(j), points.get(m)))
                            min = mianji(points.get(i), points.get(j), points.get(m));

                        areas.add(mianji(points.get(i), points.get(j), points.get(m)));
                    }
                }
            }
            DecimalFormat df = new DecimalFormat("0.0");

            System.out.print(df.format(min));
            System.out.print(" " + df.format(max));
            System.out.println();
            count = scanner.nextInt();
        }
    }

    static class Point {
        private Double x;
        private Double y;

        public Point(Double x, Double y) {
            this.x = x;
            this.y = y;
        }
    }

    static double mianji(Point a, Point b, Point c) {
        double s = (side_long(a, b) + side_long(a, c) + side_long(b, c)) / 2;
        double h = sqrt(s * (s - side_long(b, c)) * (s - side_long(a, c)) * (s - side_long(a, b)));
        return h;
    }

    static Double side_long(Point a, Point b) {
        Double h;
        h = sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        return h;
    }
}
