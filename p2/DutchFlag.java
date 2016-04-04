package p2;

/**
 * Created by Mateus Antonio on 04/03/2016.
 */

public class DutchFlag {

    static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    static void dutch_flag(int[] a) {
        int r = a.length;
        int b = 0;
        int i = 0;
        while (i < r) {
            if (a[i] == 0) {
                swap(a, b, i);
                b++;
                i++;
            } else if (a[i] == 1) {
                i++;
            } else {
                swap(a, r - 1, i);
                if (r >= i) r--;
            }
        }
    }
}
