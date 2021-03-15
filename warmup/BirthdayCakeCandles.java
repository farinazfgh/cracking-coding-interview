package warmup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BirthdayCakeCandles {
    public static int birthdayCakeCandles(List<Integer> candles) {

        if (candles == null || candles.size() == 0) return 0;

        int tallCandles = 1;

        Collections.sort(candles);//TODO could change to radix sort

        int i = candles.size() - 1;
        //beware of array index , start from end compare i, i-1 while i>0, runs i=1 inclusive
        while (i > 0) {
            if (candles.get(i).equals(candles.get(i - 1))) {
                i--;
                tallCandles++;
            } else break;
        }
        return tallCandles;
    }


    private static List<Integer> readFileToList(String fileName) {
        String[] array = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                array = line.split(" ");
            }
            List<Integer> list = new ArrayList<>();
            for (String s : array) {
                list.add(Integer.parseInt(s));
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
