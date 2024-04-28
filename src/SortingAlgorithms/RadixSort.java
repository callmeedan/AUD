package SortingAlgorithms;

import java.util.ArrayList;

public class RadixSort {

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
