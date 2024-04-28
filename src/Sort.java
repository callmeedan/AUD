import java.util.ArrayList;

import static java.lang.Math.floor;

public class Sort {
    public Sort(){}

    public static void insertionSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j = j - 1;
            }
            a[j+1] = key;
        }
    }

    public static void RecursiveInsertionSort(int[] a, int i){
        if (i<=1){return;} // Base case
        RecursiveInsertionSort(a,i-1); // Recursively sort first n-1 element
        int key = a[i-1];
        int j = i-2;
        while (j >= 0 && a[j] > key){
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = key;
    }

    public static void insertionSortReverse(int[] a){
        for (int i = a.length-2; i >= 0; i--) {
            int key = a[i];
            int j = i + 1;
            while (j <= a.length-1 && a[j] > key) {
                a[j-1] = a[j];
                j = j + 1;
            }
            a[j-1] = key;
        }
    }

    public static void RecursiveInsertionSortReverse(int[] a, int i){
        if (i >= a.length-2){return;}
        RecursiveInsertionSortReverse(a,i+1);
        int key = a[i+1];
        int j = i+2;
        while (j <= a.length-1 && a[j] > key){
            a[j-1] = a[j];
            j++;
        }
        a[j-1] = key;
    }

    public static void bubbleSort(int[] a){
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

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

    public static void radixSort(int[] A, int d, int D){
        // Create buckets
        ArrayList<Integer>[] B = new ArrayList[D];
        for (int i = 0; i < D; i++) {
            B[i] = new ArrayList<>();
        }

        // Sort by each digit from least to most significant
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < A.length; j++) {
                putBucket(A,B,i,j);
            }
            int a = 0;
            for (int k = 0; k < D; k++) {
                for (int b = 0; b < B[k].size(); b++) {
                    A[a] = B[k].get(b);
                    a = a+1;
                }
                B[k].clear();
            }
        }
    }

    private static void putBucket(int[] A, ArrayList<Integer>[] B, int i, int j){
        int z = getDigit(A[j],i);
        B[z].add(A[j]);
    }

    private static int getDigit(int num, int i) {
        return (num / (int)Math.pow(10, i)) % 10;
    }
}


