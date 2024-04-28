package SortingAlgorithms;

public class InsertionSort {

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
}
