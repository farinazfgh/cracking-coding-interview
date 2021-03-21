package sortingsearching.classic;

import java.util.NoSuchElementException;

public class MinPQ {
    private int[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue

    public static void main(String[] args) {
        MinPQ pq = new MinPQ();
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int item : array) {
            pq.insert(item);
            // else if (!pq.isEmpty()) StdOut.print(pq.delMin() + " ");
        }
    }

    public int delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        //       pq[n+1] = null;     to avoid loitering and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return min;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(int x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // resize the underlying array to have the given capacity
    private void resize(int capacity) {
        assert capacity > n;
        int[] temp = new int[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && greater(k, left)) return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    private boolean greater(int i, int j) {
        return (pq[i] > pq[j]);
    }
}
