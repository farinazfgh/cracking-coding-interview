package hackerrank.problemsolving.basic;

public class NumberLineJumps {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 == x2) {
            if (v1 != v2) return "NO";
            return "YES";
        }
        if (x1 < x2 && v1 < v2) return "NO";
        if (x2 < x1 && v2 < v1) return "NO";
        //x1 + y * v1 = x2 + y * v2  x1-x2= y*(v2-v1)
        if (v1 > v2) {
            int remainder = (x1 - x2) % (v2 - v1);

            if (remainder == 0) {
                return "YES";
            }
        }
        return "NO";
    }
}
