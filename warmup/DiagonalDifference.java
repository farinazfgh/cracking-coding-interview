package warmup;

import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        if (arr == null || arr.size() == 0) return 0;
        int mainDiagonalSum = 0;
        int couterDiagonalSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; arr.get(i) != null && j < arr.get(i).size(); j++) {
                if (i == j) mainDiagonalSum += arr.get(i).get(j);
                if (i + j == arr.size() - 1) couterDiagonalSum += arr.get(i).get(j);
            }
        }
        return Math.abs(mainDiagonalSum - couterDiagonalSum);
    }
}
