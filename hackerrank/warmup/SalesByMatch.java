package hackerrank.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    practice counting mod, div, etc. GCD LCM
 */
public class SalesByMatch {

    static int sockMerchant(int n, int[] ar) {

        int numberOfPairs = 0;

        Map<Integer, List<Integer>> socks = new HashMap<>();

        for (int val : ar) {
            List<Integer> list = socks.get(val);

            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(val);
            socks.put(val, list);
        }
        for (Map.Entry<Integer, List<Integer>> entry : socks.entrySet()) {
            int size = entry.getValue().size();
            int div = size / 2;
            numberOfPairs += div;
        }
        return numberOfPairs;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(array.length, array));
    }
}
