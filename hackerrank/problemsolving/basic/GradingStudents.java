package hackerrank.problemsolving.basic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedList = new LinkedList<>();

        for (Integer grade : grades) {
            if (grade < 38 || grade % 5 < 3) {
                roundedList.add(grade);
            } else roundedList.add(grade + (5 - (grade % 5)));
        }
        return roundedList;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 80, 96, 18, 73, 78, 60, 60, 15, 45, 15, 10, 5, 46, 87, 33, 60, 14, 71, 65, 2, 5, 97, 0);
        System.out.println(gradingStudents(list));
    }
}
