import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        int[] test = {123, 245, 23, 26, 134, 634, 118, 611, 148};
        Sort.radixSort(test, 3, 10);
        System.out.println(Arrays.toString(test));
    }
}
