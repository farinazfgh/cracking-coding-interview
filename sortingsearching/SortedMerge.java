package sortingsearching;

public class SortedMerge {
    /*
    Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
    end to hold B. Write a method to merge B into A in sorted order
     */
    static int[] sortedMarge(int[] A, int[] B, int lastA) {
        int index = lastA + B.length;
        int aIndex = lastA;
        int bIndex = B.length - 1;
        while (index >= 0 && aIndex >= 0 && bIndex >= 0) {
            if (A[aIndex] > B[bIndex]) {
                A[index] = A[aIndex];
                aIndex--;
            } else {
                A[index] = B[bIndex];
                bIndex--;
            }
            index--;
        }
        return A;
    }

    static int min(int a, int b) {
        return Math.min(a, b);
    }

    static void printArray(int[] array) {
        for (int val : array) {
            System.out.print(val + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[10];
        A[0] = 1;
        A[1] = 3;
        A[2] = 5;
        A[3] = 7;
        int[] B = {2, 4, 6};
        System.out.println(A.length);
        printArray(sortedMarge(A, B, 3));

    }

    void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1; /* Index of last element in array a */
        int indexB = lastB - 1; /* Index of last element in array b */
        int indexMerged = lastB + lastA - 1; /* end of merged array */

        /* Merge a and b, starting from the last element in each */
        while (indexB >= 8) {
            /* end of a is > than end of b */
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
    }
}
