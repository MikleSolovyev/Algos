import java.util.Arrays;

public class myVector<E> {

    private E[] mas;
    private int size;
    private int capacity;


    public myVector() {
        this(0);
    }

    public myVector(int size) {
        this.mas = (E[])(new Object[2 * size + 10]);
        this.size = size;
        this.capacity = 2 * size + 10;
    }

    public myVector(myVector<E> vector) {
        this.mas = Arrays.copyOf(vector.mas, vector.capacity);
        this.size = vector.size;
        this.capacity = vector.capacity;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;

        if (size > capacity) {
            capacity = 2 * size + 10;
            mas = Arrays.copyOf(mas, capacity);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        try {
            if (capacity < 0) {
                throw new NegativeArraySizeException("Negative myVector capacity!");
            }

            this.capacity = capacity;
            mas = Arrays.copyOf(mas, capacity);

            if (size > capacity) {
                size = capacity;
            }
        }
        catch (NegativeArraySizeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addLast(E element) {
        setSize(size + 1);

        mas[size - 1] = element;
    }

    public void delLast() {
        try {
            if (size == 0) {
                throw new RuntimeException("myVector is empty!");
            }

            setSize(size - 1);
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void insertByIndex(E data, int index) {
        try {
            if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("Incorrect index!");
            }

            mas[index] = data;
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delByIndex(int index) {
        try {
            if (size == 0) {
                throw new IndexOutOfBoundsException("myVector is empty!");
            }
            if (index < 0 || index > size - 1) {
                throw new IndexOutOfBoundsException("Incorrect index!");
            }

            setSize(size - 1);

            for (int i = index; i < size; i++) {
                mas[i] = mas[i + 1];
            }
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void clear() {
        setSize(0);
    }

    public void printVector() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println("]");
    }
}
