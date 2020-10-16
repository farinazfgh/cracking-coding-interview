package solutionstojava;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TreeMapHashMapLinkedHashMap {
    static void insertAndPrint(AbstractMap<Integer, String> map) {
        int[] array = {1, -1, 0};
        for (int x : array) {
            map.put(x, Integer.toString(x));
        }

        for (int k : map.keySet()) {
            System.out.print(k + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertAndPrint(new HashMap<>());
        insertAndPrint(new TreeMap<>());
        insertAndPrint(new LinkedHashMap<>());
    }
}
