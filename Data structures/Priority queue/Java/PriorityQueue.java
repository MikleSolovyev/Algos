import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>, S extends List<E>> {

    private S container;

    public PriorityQueue() {
        List<E> container = new ArrayList<>();
        this.container = (S) container;
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }

    public int getSize() {
        return container.size();
    }

    private void swap(int firstIndex, int secondIndex) {
        E temp = container.get(firstIndex);
        container.set(firstIndex, container.get(secondIndex));
        container.set(secondIndex, temp);
    }

    private void siftUp(int i) {
        while (i > 0 &&
                container.get(i).compareTo(container.get((i - 1) / 2)) > 0) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void siftDown(int i) {
        while (true) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            int largest = i;

            if (leftIndex < container.size() &&
                    container.get(leftIndex)
                            .compareTo(container.get(largest)) > 0) {
                largest = leftIndex;
            }
            if (rightIndex < container.size() &&
                    container.get(rightIndex)
                            .compareTo(container.get(largest)) > 0) {
                largest = rightIndex;
            }
            if (i == largest) {
                break;
            }

            swap(i, largest);
            i = largest;
        }
    }

    public void add(E element) {
        container.add(element);
        siftUp(container.size() - 1);
    }

    public void remove(E element) {
        int lastIndex = container.size() - 1;
        int i;

        if (lastIndex == -1) {
            System.out.println("PriorityQueue is empty!");
            return;
        }

        if (element != container.get(lastIndex)) {
            boolean isExist = false;
            for (i = 0; i <= lastIndex; i++) {
                if (container.get(i) == element) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                System.out.println("This element does not exist in PriorityQueue!");
                return;
            }

            int equalResult = container.get(i).compareTo(container.get(lastIndex));
            swap(i, lastIndex);
            container.remove(lastIndex);

            if (equalResult < 0) {
                siftUp(i);
            } else if (equalResult > 0) {
                siftDown(i);
            }
        } else {
            container.remove(lastIndex);
        }
    }

    public E getMax() {
        return container.get(0);
    }

    public void print() {
        System.out.println("-----------------------------------------------");
        System.out.println(container.get(0));
        for (int i = 1, j = 2, k = 2; i < container.size(); i++) {
            if (i < k) {
                System.out.print(container.get(i) + " ");
            } else {
                System.out.println(container.get(i));
                j *= 2;
                k += j;
            }
        }
        System.out.println("\n-----------------------------------------------");
    }
}
