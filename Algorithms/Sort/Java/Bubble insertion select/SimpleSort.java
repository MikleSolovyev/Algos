import java.util.List;

public class SimpleSort {

    public static void bubble(int[] array) {
        bubble(array, 0, array.length - 1);
    }
    public static void bubble(int[] array, int indexLeft, int indexRight) {
        for (int i = indexRight; i > indexLeft; i--) {
            for (int j = indexLeft; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubble(T[] array) {
        bubble(array, 0, array.length - 1);
    }

    public static <T extends Comparable<? super T>> void bubble(T[] array, int indexLeft, int indexRight) {
        for (int i = indexRight; i > indexLeft; i--) {
            for (int j = indexLeft; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubble(List<T> list) {
        bubble(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<? super T>> void bubble(List<T> list, int indexLeft, int indexRight) {
        for (int i = indexRight; i > indexLeft; i--) {
            for (int j = indexLeft; j < i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void insertion(int[] array) {
        insertion(array, 0, array.length - 1);
    }
    public static void insertion(int[] array, int indexLeft, int indexRight) {
        for (int i = indexLeft + 1; i <= indexRight; i++) {
            for (int j = i; j > indexLeft && array[j - 1] > array[j]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    public static <T extends Comparable<? super T>> void insertion(T[] array) {
        insertion(array, 0, array.length - 1);
    }

    public static <T extends Comparable<? super T>> void insertion(T[] array, int indexLeft, int indexRight) {
        for (int i = indexLeft + 1; i <= indexRight; i++) {
            for (int j = i; j > indexLeft && array[j - 1].compareTo(array[j]) > 0; j--) {
                T temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    public static <T extends Comparable<? super T>> void insertion(List<T> list) {
        insertion(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<? super T>> void insertion(List<T> list, int indexLeft, int indexRight) {
        for (int i = indexLeft + 1; i <= indexRight; i++) {
            for (int j = i; j > indexLeft && list.get(j - 1).compareTo(list.get(j)) > 0; j--) {
                T temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
            }
        }
    }

    public static void select(int[] array) {
        select(array, 0, array.length - 1);
    }
	
    public static void select(int[] array, int indexLeft, int indexRight) {
        for (int i = indexLeft; i <= indexRight; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j <= indexRight; j++) {
                if (array[indexOfMin] > array[j]) {
                    indexOfMin = j;
                }
            }

            int temp = array[i];
            array[i] = array[indexOfMin];
            array[indexOfMin] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void select(T[] array) {
        select(array, 0, array.length - 1);
    }

    public static <T extends Comparable<? super T>> void select(T[] array, int indexLeft, int indexRight) {
        for (int i = indexLeft; i <= indexRight; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j <= indexRight; j++) {
                if (array[indexOfMin].compareTo(array[j]) > 0) {
                    indexOfMin = j;
                }
            }

            T temp = array[i];
            array[i] = array[indexOfMin];
            array[indexOfMin] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void select(List<T> list) {
        select(list, 0, list.size() - 1);
    }

    public static <T extends Comparable<? super T>> void select(List<T> list, int indexLeft, int indexRight) {
        for (int i = indexLeft; i <= indexRight; i++) {
            int indexOfMin = i;

            for (int j = i + 1; j <= indexRight; j++) {
                if (list.get(indexOfMin).compareTo(list.get(j)) > 0) {
                    indexOfMin = j;
                }
            }

            T temp = list.get(i);
            list.set(i, list.get(indexOfMin));
            list.set(indexOfMin, temp);
        }
    }
}
