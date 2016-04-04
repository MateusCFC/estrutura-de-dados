package p2;

/**
 * Created by Mateus Antonio on 04/03/2016.
 */

public class Quicksort {
    static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    static int partition(int[] a, int l, int r) {
        int start = l;
        int end = r;
        int pivo = l;
        int flagleft = 0;
        int flagright = 1;
        int temp;
        while (true) {
            if (start >= end) break;
            if (flagright == 1) {
                if (a[pivo] <= a[end]) end--;
                else {
                    temp = end;
                    swap(a, pivo, end);
                    pivo = temp;
                    flagright = 0;
                    flagleft = 1;
                }
            }
            if (flagleft == 1) {
                if (a[pivo] > a[start]) start++;
                else {
                    temp = start;
                    swap(a, pivo, start);
                    pivo = temp;
                    flagleft = 0;
                    flagright = 1;
                }
            }
        }
        return pivo;
    }

    static void quickrec(int[] a, int l, int r) {
        int index = partition(a, l, r);
        if (index > l) quickrec(a, l, index - 1);
        if (index < r) quickrec(a, index + 1, r);
    }

    static void quicksort(int[] a) {
        quickrec(a, 0, a.length - 1);
    }
}
