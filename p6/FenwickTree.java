package p6;

/**
 * Created by mateuscfc on 03/05/16.
 */

public class FenwickTree {
    int value;
    int leftSize;
    FenwickTree left;
    FenwickTree right;

    public FenwickTree(int value){
        this.value = value;
        leftSize = 0;
        left = null;
        right = null;
    }

    public FenwickTree(int leftSize, FenwickTree left, FenwickTree right){
        this.left = left;
        this.right = right;
        this.leftSize = leftSize;
        this.value = left.value + right.value;
    }

    @Override
    public String toString(){
        if (left == null || right == null) return "[" + value + ", " + leftSize + "]";
        else {
            return "[" + value + ", " + leftSize + ", " + left.toString() + ", " + right.toString() + "]";
        }
    }

    static FenwickTree allZeros(int n){
        if (n==0) return null;
        if (n==1) return new FenwickTree(0);
        int m = n/2;
        return new FenwickTree(n-m, allZeros(n-m), allZeros(m));
    }

    int size(){
        if (left == null && right == null) return 1;
        else return right.size() + left.size();
    }

    void increment(int i, int delta){
        this.value += delta;
        if (left == null && right == null) return;
        else{
            if (i < leftSize) left.increment(i,delta);
            else right.increment(i-leftSize,delta);
        }
    }

    int prefixSum(int upto){
        if (right == null && left == null) return value;
        else {
            int aux = 0;
            if (upto > 0) aux += left.prefixSum(upto);
            if (upto > leftSize) aux += right.prefixSum(upto-leftSize);
            return aux;
        }
    }

    int between(int lo, int hi){
        return prefixSum(hi)-prefixSum(lo);
    }
}
