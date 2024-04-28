import java.util.Arrays;
import java.util.Random;

import SortingAlgorithms.*;
import DataStructures.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
//        int[] a = randomArrayGenerator(10);
        ArrayStack as = new ArrayStack(1);
        as.push(10);
        as.printStack();

        DynamicArrayStack ds = new DynamicArrayStack(1);
        ds.push(10);
        ds.push(10);
        ds.push(10);
        ds.printStack();
    }

    private static int[] randomArrayGenerator(int size){
        int[] a = new int[size];
        Random random = new Random();
        for (int i = 0; i < a.length; i++){
            a[i] = random.nextInt(0, 1000);
            if (i>=1) {
                for (int j = 0; j < i; j++) {
                    while (a[j] == a[i]) {
                        a[i] = random.nextInt(0, 1000);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }
}
