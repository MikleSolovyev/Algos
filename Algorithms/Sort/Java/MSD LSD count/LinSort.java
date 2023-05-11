import java.math.BigInteger;
import java.util.ArrayList;

public class LinSort {

    public static void msdSort(int[] array) {
        msdSort(array, 0, array.length - 1);
    }

    public static void msdSort(int[] array, int leftIndex, int rightIndex) {
        BigInteger[] BigIntegerArray = new BigInteger[array.length];

        for (int i = 0; i < array.length; i++) {
            BigIntegerArray[i] = BigInteger.valueOf(array[i]);
        }

        msdSort(BigIntegerArray, leftIndex, rightIndex);

        for (int i = 0; i < array.length; i++) {
            array[i] = BigIntegerArray[i].intValue();
        }
    }

    public static void msdSort(BigInteger[] array) {
        lsdSort(array, 0, array.length - 1);
    }

    public static void msdSort(BigInteger[] array, int leftIndex, int rightIndex) {
        ArrayList<ArrayList<BigInteger>> radixArray = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            radixArray.add(new ArrayList<>());
        }

        BigInteger maxAbsValue = BigInteger.valueOf(-1);

        for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i].abs().compareTo(maxAbsValue) > 0) {
                maxAbsValue = array[i];
            }
        }

        BigInteger divisor = BigInteger.ONE;

        while (maxAbsValue.divide(BigInteger.TEN).compareTo(BigInteger.ZERO) > 0) {
            divisor = divisor.multiply(BigInteger.TEN);

            maxAbsValue = maxAbsValue.divide(BigInteger.TEN);
        }

        for (int i = leftIndex; i <= rightIndex; i++) {
            if (array[i].compareTo(BigInteger.ZERO) < 0) {
                radixArray.get(0).add(array[i]);
            } else {
                radixArray.get(1).add(array[i]);
            }
        }

        int arrayIndex = leftIndex;

        for (int i = 0; i < 2; i++) {
            for (BigInteger element : radixArray.get(i)) {
                array[arrayIndex++] = element;
            }

            radixArray.get(i).clear();
        }

        while (divisor.compareTo(BigInteger.ZERO) > 0) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                BigInteger temp = array[i].abs().divide(divisor);
                radixArray.get(temp.mod(BigInteger.TEN).intValue()).add(array[i]);
            }

            arrayIndex = leftIndex;

            for (int i = 0; i < 10; i++) {
                for (BigInteger element : radixArray.get(i)) {
                    array[arrayIndex++] = element;
                }

                radixArray.get(i).clear();
            }

            divisor = divisor.divide(BigInteger.TEN);
        }
    }

    public static void lsdSort(int[] array) {
        lsdSort(array, 0, array.length - 1);
    }

    public static void lsdSort(int[] array, int leftIndex, int rightIndex) {
        BigInteger[] BigIntegerArray = new BigInteger[array.length];

        for (int i = 0; i < array.length; i++) {
            BigIntegerArray[i] = BigInteger.valueOf(array[i]);
        }

        lsdSort(BigIntegerArray, leftIndex, rightIndex);

        for (int i = 0; i < array.length; i++) {
            array[i] = BigIntegerArray[i].intValue();
        }
    }

    public static void lsdSort(BigInteger[] array) {
        lsdSort(array, 0, array.length - 1);
    }

    public static void lsdSort(BigInteger[] array, int leftIndex, int rightIndex) {
        ArrayList<ArrayList<BigInteger>> radixArray = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            radixArray.add(new ArrayList<>());
        }

        boolean flag = false;
        BigInteger divisor = BigInteger.ONE;

        while (!flag) {
            flag = true;

            for (int i = leftIndex; i <= rightIndex; i++) {
                BigInteger temp = array[i].divide(divisor);
                radixArray.get(temp.mod(BigInteger.TEN).intValue()).add(array[i]);

                if (flag && temp.abs().compareTo(BigInteger.ZERO) > 0) {
                    flag = false;
                }
            }

            if (flag) {
                for (int i = radixArray.get(0).size() - 1; i >= 0; i--) {
                    if (radixArray.get(0).get(i).compareTo(BigInteger.ZERO) < 0) {
                        radixArray.get(1).add(radixArray.get(0).get(i));

                        radixArray.get(0).remove(i);
                    }
                }

                ArrayList<BigInteger> temp = new ArrayList<>(radixArray.get(0));
                radixArray.get(0).clear();
                radixArray.get(0).addAll(radixArray.get(1));
                radixArray.get(1).clear();
                radixArray.get(1).addAll(temp);
            }

            int arrayIndex = leftIndex;

            for (int i = 0; i < 10; i++) {
                for (BigInteger element : radixArray.get(i)) {
                    array[arrayIndex++] = element;
                }

                radixArray.get(i).clear();
            }

            divisor = divisor.multiply(BigInteger.TEN);
        }
    }

    public static void countSort(int[] array) {
        countSort(array, 0, array.length - 1);
    }

    public static void countSort(int[] array, int leftIndex, int rightIndex) {
        BigInteger[] BigIntegerArray = new BigInteger[array.length];

        for (int i = 0; i < array.length; i++) {
            BigIntegerArray[i] = BigInteger.valueOf(array[i]);
        }

        countSort(BigIntegerArray, leftIndex, rightIndex);

        for (int i = 0; i < array.length; i++) {
            array[i] = BigIntegerArray[i].intValue();
        }
    }

    public static void countSort(BigInteger[] array) {
        countSort(array, 0, array.length - 1);
    }

    public static void countSort(BigInteger[] array, int leftIndex, int rightIndex) {
        BigInteger minValue = null;
        BigInteger maxValue = null;
        
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (minValue == null || minValue.compareTo(array[i]) > 0) {
                minValue = array[i];
            }

            if (maxValue == null || maxValue.compareTo(array[i]) < 0) {
                maxValue = array[i];
            }
        }

        int[] countArray = new int[maxValue.subtract(minValue).intValue() + 1];

        for (int i = leftIndex; i <= rightIndex; i++) {
            countArray[array[i].subtract(minValue).intValue()]++;
        }

        int arrayIndex = leftIndex;

        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                array[arrayIndex++] = BigInteger.valueOf(i).add(minValue);
            }
        }
    }
}
