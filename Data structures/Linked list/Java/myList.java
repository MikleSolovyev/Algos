class Elem<E> {
    E data;
    Elem<E> next;
}

public class myList<E> {

    private Elem<E> head;
    private Elem<E> tail;
    private int size = 0;

    public myList() {
    }

    public myList(myList<E> lst) {
        Elem<E> element = lst.head;

        while (element != null) {
            addTail(element.data);
            element = element.next;
        }
    }

    public void addHead(E data) {
        Elem<E> element = new Elem<>();

        element.data = data;
        size++;

        if (size == 1) {
            head = element;
            tail = element;
        } else {
            element.next = head;
            head = element;
        }
    }

    public void addTail(E data) {
        Elem<E> element = new Elem<>();

        element.data = data;
        size++;

        if (size == 1) {
            head = element;
        } else {
            tail.next = element;
        }
        tail = element;
    }

    public void delHead() {
        try {
            if (size == 0)
                throw new Exception("Can`t delete element from head: empty list");
            head = head.next;
            size--;

            if (size == 0) tail = null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delFirstByValue(E data) {
        try {
            if (size == 0)
                throw new Exception("Can`t delete element by value: empty list");

            if (head.data == data) {
                head = head.next;
                if (size < 2) tail = head;

                size--;
                return;
            }

            Elem<E> element = head;
            while (element.next != null) {
                if (element.next.data.equals(data)) {
                    size--;

                    if (element.next == tail) {
                        tail = element;
                    }

                    element.next = element.next.next;
                    return;
                }

                element = element.next;
            }

            throw new Exception("Can`t delete element by value: no element with this value in list");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getSize() {
        return size;
    }

    public void delAll() {
        head = null;
        tail = null;
        size = 0;
    }

    public void printList() {
        Elem<E> element = head;

        System.out.print("[ ");
        while (element != null) {
            System.out.print(element.data + " ");
            element = element.next;
        }
        System.out.println("]");
    }
}