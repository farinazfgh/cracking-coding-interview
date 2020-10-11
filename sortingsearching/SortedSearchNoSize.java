package sortingsearching;

public class SortedSearchNoSize {
    static class Listy {
        int[] array;

        public Listy() {
            this.array = new int[1500];//abstract data simulates a list like structure that has no end;
            for (int i = 0; i < 1000; i++) array[i] = i;
            for (int i = 1000; i < 1500; i++) array[i] = -1;
        }

        public int elementAt(int index) {
            return array[index];
        }
    }

    static int search(Listy list, int key) {
        int index = 1;

        while (list.elementAt(index) < key && list.elementAt(index) != -1) {
            index *= 2;
            System.out.println("index:" + index);
        }
        return binarySearch(list, key, index / 2, index);
    }

    static int binarySearch(Listy list, int key, int low, int high) {
        System.out.println("low:" + low + " high:" + high);
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            int middle = list.elementAt(mid);
            if (middle == key) return mid;//found key
            if (middle > key || middle == -1) {
                high = mid - 1;
            } else {// (middle < key)
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Listy listy = new Listy();
        System.out.println("***********************************************");
        System.out.println(search(listy, 1));
        System.out.println("***********************************************");

        System.out.println(search(listy, 222));
        System.out.println("***********************************************");

        System.out.println(search(listy, 10));
        System.out.println("***********************************************");

        System.out.println(search(listy, 999));
        System.out.println("***********************************************");
        System.out.println(search(listy, 1001));
        System.out.println("***********************************************");


    }
}
