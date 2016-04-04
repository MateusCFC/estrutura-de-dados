package p2;

/**
 * Created by Mateus Antonio on 04/03/2016.
 */

import java.util.LinkedList;

public class Mergesort {

    static void split(LinkedList<Integer> l, LinkedList<Integer> l1, LinkedList<Integer> l2) {
        if (l.size() % 2 == 0) {
            for (int i = 0; i < l.size() / 2; i++) {
                l1.add(l.get(i));
            }
            for (int i = l.size() / 2; i < l.size(); i++) {
                l2.add(l.get(i));
            }
        } else {
            Double x = new Double(l.size() / 2);
            for (int i = 0; i < x.intValue() + 1; i++) {
                l1.add(l.get(i));
            }
            for (int i = x.intValue() + 1; i < l.size(); i++) {
                l2.add(l.get(i));
            }
        }
    }

    static LinkedList<Integer> merge(LinkedList<Integer> l1,
                                     LinkedList<Integer> l2) {
        LinkedList<Integer> aux = new LinkedList<>();
        while (l1.size() != 0 || l2.size() != 0) {
            if (l1.size() == 0) {
                while (l2.size() != 0) {
                    aux.add(l2.get(0));
                    l2.remove(0);
                }
            } else if (l2.size() == 0) {
                while (l1.size() != 0) {
                    aux.add(l1.get(0));
                    l1.remove(0);
                }
            } else {
                if (l1.get(0) < l2.get(0)) {
                    aux.add(l1.get(0));
                    l1.remove(0);
                } else {
                    aux.add(l2.get(0));
                    l2.remove(0);
                }
            }
        }
        return aux;
    }

    static LinkedList<Integer> mergesort(LinkedList<Integer> l) {
        if (l.size() <= 1) {
            return l;
        } else {
            LinkedList<Integer> x1 = new LinkedList<>();
            LinkedList<Integer> x2 = new LinkedList<>();
            LinkedList<Integer> s1;
            LinkedList<Integer> s2;
            split(l, x1, x2);
            s1 = mergesort(x1);
            s2 = mergesort(x2);
            return merge(s1, s2);
        }
    }
}
