package SortingAlgorithms;

public class BubbleSort {

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
}
