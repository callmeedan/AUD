package SortingAlgorithms;

import static java.lang.Math.floor;

public class MergeSort {

    public static void mergeSort(int[] A, int l, int r) throws Exception{
        int m = 0;
        if (l < r) { // more than one element
            m = (int) floor((double) (l + r) / 2);
            mergeSort(A, l, m);
            mergeSort(A, m + 1, r);
            merge(A, l, m, r);
        }
    }

    private static void merge(int [] A, int l, int m, int r) throws Exception{
        if (l>m || m>r) {throw new Exception("not fulfill the requirement");}
        int[] B = new int[r-l+1];
        int pl = l;
        int pr = m+1;
        for (int i = 0; i <= r-l; i++) {
            if (pr > r || (pl <= m && A[pl] <= A[pr])) {
                B[i] = A[pl];
                pl = pl+1;
            } else {
                B[i] = A[pr];
                pr = pr+1;
            }
        }
        for (int i = 0; i <= r-l; i++) {
            A[i+l] = B[i];
        }
    }

    public static void quicksort(int[] A, int l, int r){ //initial call: L=0; r=A.length-1
        int p;
        if (l<r){
            p = partition(A,l,r);
            quicksort(A,l,p);
            quicksort(A,p+1,r);
        }
    }

    private static int partition(int[] A, int l, int r){ //requires l<r, returns int in l...r-1
        int pivot = A[l];
        int pl = l-1;
        int pr = r+1;
        while (pl<pr){
            do{pl=pl+1;}while(A[pl]<pivot);
            do{pr=pr-1;}while(A[pr]>pivot);
            if(pl<pr){
                int temp = A[pl];
                A[pl] = A[pr];
                A[pr] = temp;
            }
        }
        return pr;
    }
}
