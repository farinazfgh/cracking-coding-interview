package hackerrank.problemsolving.basic;

public class AppleOrange {
    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples
            , int[] oranges) {
        //   0-------a----s------------t----------b
        int applesno = 0;
        int orangesno = 0;

        for (int distanceFromTree : apples) {
            int distance = a + distanceFromTree;
            if (distance >= s && distance <= t) applesno++;
        }
        for (int distanceFromTree : oranges) {
            int distance = b + distanceFromTree;
            if (distance >= s && distance <= t) orangesno++;
        }
        System.out.println(applesno);
        System.out.println(orangesno);
    }
}
