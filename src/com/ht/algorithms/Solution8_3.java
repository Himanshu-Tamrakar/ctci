package com.ht.algorithms;

public class Solution8_3 {
    private boolean isDistinctAndSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if(a[i] <= a[i-1]) return false;
        }
        return true;
    }

    public int magicIndex(int[] array) {
        return isDistinctAndSorted(array) ? calculateMagicIndexForDistictKeys(array, 0, array.length-1) : calculateMagicIndexForDuplicateKeys(array, 0, array.length-1);
    }

    /**
     * IF array has distinct values
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private int calculateMagicIndexForDistictKeys(int[] array, int lo, int hi) {
        if(lo > hi) { return -1; }

        int mid = lo + (hi-lo) / 2;
        if(mid == array[mid]) return mid;
        else if(mid > array[mid]) return calculateMagicIndexForDistictKeys(array, mid+1, hi);
        else return calculateMagicIndexForDistictKeys(array, lo, mid-1);

        //Binary Search Iterative
//        while(lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            if(mid == array[mid]) return mid;
//            else if(mid > array[mid]) lo = mid+1;
//            else hi = mid-1;
//        }
//        return -1;
    }

    private int calculateMagicIndexForDuplicateKeys(int[] array, int lo, int hi) {
        if(lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;

        if(mid == array[mid]) return mid;
        int leftHi, rightLo;
        if(mid > array[mid]) {
            leftHi = array[mid];
        } else {
            leftHi = mid-1;
        }

        if(mid < array[mid]) {
            rightLo = array[mid];
        } else  {
            rightLo = mid+1;
        }
        int r1 = calculateMagicIndexForDuplicateKeys(array, lo, leftHi);
        if(r1 != -1) {
            return r1;
        }
        int r2 = calculateMagicIndexForDistictKeys(array, rightLo, hi);;
        if(r2 != -1) return r2;

        return -1;
    }


    public static void main() {
        Solution8_3 sol = new Solution8_3();
//        int[] a = new int[] {-40, -20, -1, 1,2,3,5,7,9,12,13};
        int[] a = new int[] {-10, -5, 1, 2,2,3,4,7,9,12,13};

        System.out.println(sol.magicIndex(a));

    }
}
