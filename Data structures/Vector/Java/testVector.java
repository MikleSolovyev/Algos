public class testVector {

    public static void main(String[] args) {
        var a = new myVector<>();

        a.setCapacity(-1);
        System.out.println(a.getSize());
        System.out.println(a.getCapacity());
        System.out.println();

        a.addLast(1);
        a.addLast(2);
        a.printVector();
        a.setCapacity(a.getSize());
        System.out.println(a.getSize());
        System.out.println(a.getCapacity());
        System.out.println();

        var b = new myVector<>(a);

        b.insertByIndex('a', 2);
        b.delByIndex(2);
        System.out.println();

        b.insertByIndex('a', 1);
        b.delByIndex(0);
        b.printVector();
        System.out.println(b.getSize());
        System.out.println(b.getCapacity());
        System.out.println();

        b.delLast();
        b.delLast();
        System.out.println();

        b.addLast('a');
        b.addLast('b');
        b.printVector();
        System.out.println(b.getSize());
        System.out.println(b.getCapacity());
        b.addLast(3);
        System.out.println();

        var c = new myVector<>(b);

        b.clear();
        b.printVector();
        System.out.println(b.getSize());
        System.out.println(b.getCapacity());
        System.out.println();

        c.printVector();
        System.out.println(c.getSize());
        System.out.println(c.getCapacity());
        System.out.println();

        c.setCapacity(1);
        c.printVector();
        System.out.println(c.getSize());
        System.out.println(c.getCapacity());
    }
}
