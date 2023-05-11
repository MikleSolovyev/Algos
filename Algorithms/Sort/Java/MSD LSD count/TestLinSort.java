import java.math.BigInteger;
import java.util.Arrays;

public class TestLinSort {

    public static void main(String[] args) {
        int[] array1 = new int[] {1000, 41, 573, 3, 836, 93, 508, 271, -12};

        System.out.println(Arrays.toString(array1));
        LinSort.msdSort(array1, 1, 7);
        System.out.println(Arrays.toString(array1));
        System.out.println();

        BigInteger[] array2 = new BigInteger[] {
                new BigInteger("100000000000000000000000000000000000000000000000000000000000000000000"),
                BigInteger.valueOf(3),
                BigInteger.valueOf(1),
                BigInteger.valueOf(9),
                BigInteger.valueOf(-100),
                BigInteger.valueOf(8),
                BigInteger.valueOf(11),
                BigInteger.valueOf(6),
                BigInteger.valueOf(-12)
        };

        System.out.println(Arrays.toString(array2));
        LinSort.lsdSort(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println();

        BigInteger[] array3 = new BigInteger[] {
                new BigInteger("100000000000000000000000000000000000000000000000000000000004"),
                new BigInteger("100000000000000000000000000000000000000000000000000000000005"),
                new BigInteger("100000000000000000000000000000000000000000000000000000000003"),
                new BigInteger("100000000000000000000000000000000000000000000000000000000001"),
        };

        System.out.println(Arrays.toString(array3));
        LinSort.countSort(array3);
        System.out.println(Arrays.toString(array3));
        System.out.println();
    }
}
