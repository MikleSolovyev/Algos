import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EffectiveSort {

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
	
    public static void quickSort(int[] array, int indexLeft, int indexRight) {
        int leftMarker = indexLeft;
        int rightMarker = indexRight;
        int pivotIndex = (indexRight + indexLeft) / 2;

        while (leftMarker <= rightMarker) {
            while (array[leftMarker] < array[pivotIndex]) {
                leftMarker++;
            }

            while (array[rightMarker] > array[pivotIndex]) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                int temp = array[leftMarker];
                array[leftMarker] = array[rightMarker];
                array[rightMarker] = temp;

                leftMarker++;
                rightMarker--;
            }
        }
        
        if (leftMarker < indexRight) {
            quickSort(array, leftMarker, indexRight);
        }
        if (rightMarker > indexLeft) {
            quickSort(array, indexLeft, rightMarker);
        }
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] array, int indexLeft, int indexRight) {
        int leftMarker = indexLeft;
        int rightMarker = indexRight;
        int pivotIndex = (indexRight + indexLeft) / 2;

        while (leftMarker <= rightMarker) {
            while (array[leftMarker].compareTo(array[pivotIndex]) < 0) {
                leftMarker++;
            }

            while (array[rightMarker].compareTo(array[pivotIndex]) > 0) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                T temp = array[leftMarker];
                array[leftMarker] = array[rightMarker];
                array[rightMarker] = temp;

                leftMarker++;
                rightMarker--;
            }
        }

        if (leftMarker < indexRight) {
            quickSort(array, leftMarker, indexRight);
        }
        if (rightMarker > indexLeft) {
            quickSort(array, indexLeft, rightMarker);
        }
    }

    public static <T extends Comparable<? super T>> void quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<? super T>> void quickSort(List<T> list, int indexLeft, int indexRight) {
        int leftMarker = indexLeft;
        int rightMarker = indexRight;
        int pivotIndex = (indexRight + indexLeft) / 2;

        while (leftMarker <= rightMarker) {
            while (list.get(leftMarker).compareTo(list.get(pivotIndex)) < 0) {
                leftMarker++;
            }

            while (list.get(rightMarker).compareTo(list.get(pivotIndex)) > 0) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                T temp = list.get(leftMarker);
                list.set(leftMarker, list.get(rightMarker));
                list.set(rightMarker, temp);

                leftMarker++;
                rightMarker--;
            }
        }

        if (leftMarker < indexRight) {
            quickSort(list, leftMarker, indexRight);
        }
        if (rightMarker > indexLeft) {
            quickSort(list, indexLeft, rightMarker);
        }
    }

    public static void heapSort(int[] array) {
        heapSort(array, 0, array.length - 1);
    }
	
    public static void heapSort(int[] array, int indexLeft, int indexRight) {
        int len = indexRight - indexLeft + 1;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(array, indexLeft, len, i);
        }

        for (int i = indexRight; i >= indexLeft; i--) {
            int temp = array[indexLeft];
            array[indexLeft] = array[i];
            array[i] = temp;

            heapify(array, indexLeft, --len, 0);
        }
    }

    private static void heapify(int[] array, int offset, int len, int i) {
        int rootIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < len && array[leftIndex + offset] > array[rootIndex + offset]) {
            rootIndex = leftIndex;
        }

        if (rightIndex < len && array[rightIndex + offset] > array[rootIndex + offset]) {
            rootIndex = rightIndex;
        }

        if (rootIndex != i) {
            int temp = array[i + offset];
            array[i + offset] = array[rootIndex + offset];
            array[rootIndex + offset] = temp;

            heapify(array, offset, len, rootIndex);
        }
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] array) {
        heapSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] array, int indexLeft, int indexRight) {
        int len = indexRight - indexLeft + 1;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(array, indexLeft, len, i);
        }

        for (int i = indexRight; i >= indexLeft; i--) {
            T temp = array[indexLeft];
            array[indexLeft] = array[i];
            array[i] = temp;

            heapify(array, indexLeft, --len, 0);
        }
    }

    private static <T extends Comparable<? super T>> void heapify(T[] array, int offset, int len, int i) {
        int rootIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < len && array[leftIndex + offset].compareTo(array[rootIndex + offset]) > 0) {
            rootIndex = leftIndex;
        }

        if (rightIndex < len && array[rightIndex + offset].compareTo(array[rootIndex + offset]) > 0) {
            rootIndex = rightIndex;
        }

        if (rootIndex != i) {
            T temp = array[i + offset];
            array[i + offset] = array[rootIndex + offset];
            array[rootIndex + offset] = temp;

            heapify(array, offset, len, rootIndex);
        }
    }

    public static <T extends Comparable<? super T>> void heapSort(List<T> list) {
        heapSort(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<? super T>> void heapSort(List<T> list, int indexLeft, int indexRight) {
        int len = indexRight - indexLeft + 1;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(list, indexLeft, len, i);
        }

        for (int i = indexRight; i >= indexLeft; i--) {
            T temp = list.get(indexLeft);
            list.set(indexLeft, list.get(i));
            list.set(i, temp);

            heapify(list, indexLeft, --len, 0);
        }
    }

    private static <T extends Comparable<? super T>> void heapify(List<T> list, int offset, int len, int i) {
        int rootIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < len && list.get(leftIndex + offset).compareTo(list.get(rootIndex + offset)) > 0) {
            rootIndex = leftIndex;
        }

        if (rightIndex < len && list.get(rightIndex + offset).compareTo(list.get(rootIndex + offset)) > 0) {
            rootIndex = rightIndex;
        }

        if (rootIndex != i) {
            T temp = list.get(i + offset);
            list.set(i + offset, list.get(rootIndex + offset));
            list.set(rootIndex + offset, temp);

            heapify(list, offset, len, rootIndex);
        }
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
	
    public static void mergeSort(int[] array, int indexLeft, int indexRight) {
        if (indexRight - indexLeft + 1 < 2) {
            return;
        }

        int indexOfMid = (indexRight - indexLeft + 1) / 2;
        int[] leftArray = Arrays.copyOfRange(array, indexLeft, indexLeft + indexOfMid);
        int[] rightArray = Arrays.copyOfRange(array, indexLeft + indexOfMid, indexRight + 1);

        mergeSort(leftArray, 0, leftArray.length - 1);
        mergeSort(rightArray, 0, rightArray.length - 1);

        merge(array, leftArray, rightArray, indexLeft);
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray, int k) {
        int i = 0;
        int j = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] array, int indexLeft, int indexRight) {
        if (indexRight - indexLeft + 1 < 2) {
            return;
        }

        int indexOfMid = (indexRight - indexLeft + 1) / 2;
        T[] leftArray = Arrays.copyOfRange(array, indexLeft, indexLeft + indexOfMid);
        T[] rightArray = Arrays.copyOfRange(array, indexLeft + indexOfMid, indexRight + 1);

        mergeSort(leftArray, 0, leftArray.length - 1);
        mergeSort(rightArray, 0, rightArray.length - 1);

        merge(array, leftArray, rightArray, indexLeft);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array, T[] leftArray, T[] rightArray, int k) {
        int i = 0;
        int j = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(List<T> list) {
        mergeSort(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<? super T>> void mergeSort(List<T> list, int indexLeft, int indexRight) {
        if (indexRight - indexLeft + 1 < 2) {
            return;
        }

        int indexOfMid = (indexRight - indexLeft + 1) / 2;
        List<T> leftArray = new ArrayList<>(list.subList(indexLeft, indexLeft + indexOfMid));
        List<T> rightArray = new ArrayList<>(list.subList(indexLeft + indexOfMid, indexRight + 1));

        mergeSort(leftArray, 0, leftArray.size() - 1);
        mergeSort(rightArray, 0, rightArray.size() - 1);

        merge(list, leftArray, rightArray, indexLeft);
    }

    private static <T extends Comparable<? super T>> void merge(List<T> list, List<T> leftArray, List<T> rightArray, int k) {
        int i = 0;
        int j = 0;

        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i).compareTo(rightArray.get(j)) <= 0) {
                list.set(k++, leftArray.get(i++));
            } else {
                list.set(k++, rightArray.get(j++));
            }
        }

        while (i < leftArray.size()) {
            list.set(k++, leftArray.get(i++));
        }

        while (j < rightArray.size()) {
            list.set(k++, rightArray.get(j++));
        }
    }
}
