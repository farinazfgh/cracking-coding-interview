package linearprogramming;

public class LineIntersection {

    static class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Line {
        public double slope, yintercept;

        public Line(Point start, Point end) {
            double deltaY = end.y - start.y;
            double deltaX = end.x - start.x;
            slope = deltaY / deltaX;
            // Will be Infinity (not exception)when deltaX=0
            yintercept = end.y - slope * end.x;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "slope=" + slope +
                    ", yintercept=" + yintercept +
                    '}';
        }
    }


    static Point intersection(Point start1, Point end1, Point start2, Point end2) {
        /* Rearranging these so that, in order of x values: start is before end and
         * point 1 is before point 2. This will make some of the later logic simpler. */
        if (start1.x > end1.x) swap(start1, end1);
        if (start2.x > end2.x) swap(start2, end2);
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);

        }

        /* Compute lines (including slope and y-intercept). */
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        /* If the lines are parallel, they intercept only if they have the same y
         * inter cept and start 2 is on line 1. */
        if (line1.slope == line2.slope) {
            if (line1.yintercept == line2.yintercept && isBetween(start1, start2, end1)) {
                return start2;
            }
            return null;
        }
        /* Get intersection coordinate. */
        double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
        double y = x * line1.slope + line1.yintercept;
        Point intersection = new Point(x, y);
        /* Check if within line segment range. */
        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
            return intersection;
        }
        return null;
    }

    /* Checks if middle is between start and end. */
    static boolean isBetween(double start, double middle, double end) {

        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;

        }
    }

    /* Checks if middle is between start and end. */
    static boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) &&
                isBetween(start.y, middle.y, end.y);
    }

    /* Swap coordinates of point one and two. */
    static void swap(Point one, Point two) {
        Point temp=one;
        one=two;
        two=temp;

    }

    public static void main(String[] args) {
       /*
        Input : A = (1, 1), B = (4, 4);          C = (1, 8), D = (2, 4)
        Input : A = (0, 1), B = (0, 4);          C = (1, 8), D = (1, 4)
        */
        System.out.println(intersection(new Point(1, 1), new Point(4, 4), new Point(1, 8), new Point(2, 4)));
        System.out.println(intersection(new Point(1, 1), new Point(4, 4), new Point(1, 8), new Point(3, 0)));
        System.out.println(intersection(new Point(0, 1), new Point(0, 4), new Point(1, 8), new Point(1, 4)));
    }
}

