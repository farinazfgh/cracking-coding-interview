package recursiondynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
Power Set: Write a method to return all subsets of a set.
 */
public class PowerSetCombinators {
    int factorial(int n) {
        return n * factorial(n - 1);
    }

    void getSubSetswithLength(int n, int length) {
        char[] set = {'A', 'B', 'C', 'D', 'E', 'F'};

        List<List<String>> allsets = new ArrayList<>();

    }

    ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size(); /* Compute 2An */
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertlntToSet(k, set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    ArrayList<Integer> convertlntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

}
