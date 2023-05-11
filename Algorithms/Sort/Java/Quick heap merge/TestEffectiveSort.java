import java.util.ArrayList;
import java.util.Arrays;

public class TestEffectiveSort {

    public static void main(String[] args) {
        int[] array1 = new int[] {100, 3, 1, 9, 8, 11, 6, -12};

        System.out.println(Arrays.toString(array1));
        EffectiveSort.quickSort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println();

        Double[] array2 = new Double[] {100.1324, 3.9, 1.3, 9.25, 8.69, 11.96, 6.38, -12.124};
        ArrayList<Double> array3 = new ArrayList<>(Arrays.asList(array2));

        System.out.println(Arrays.toString(array2));
        EffectiveSort.heapSort(array2, 1, 6);
        System.out.println(Arrays.toString(array2));
        System.out.println();

        System.out.println(Arrays.toString(array3.toArray()));
        EffectiveSort.mergeSort(array3);
        System.out.println(Arrays.toString(array3.toArray()));
        System.out.println();
    }
}
