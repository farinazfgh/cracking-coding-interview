package sortingsearching;

public class SparseSearch {
    int search(String[] strings, String str, int low, int high) {
        if (low > high) return -1;
        /* Move mid to the middle */
        int mid = (high + low) / 2;

        /*If mid is empty, find closest non -empty string. */
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < low && right > high) {//passed the boundries
                    return -1;
                } else if (right <= high && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= low && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++; //shift right and left
                left--;
            }
        }

        /* Check for string, and recurse if necessary */
        if (str.equals(strings[mid])) {
            // Found it !
            return mid;
        } else if (strings[mid].compareTo(str) < 0) {
            // Search right
            return search(strings, str, mid + 1, high);
        } else {
            // Search left
            return search(strings, str, low, mid - 1);
        }
    }

    int search(String[] strings, String str) {
        if (strings == null || str == null || str == "") {
            return -1;
        }

        return search(strings, str, 0, strings.length - 1);
    }
}
