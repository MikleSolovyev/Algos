public class testList {
	
    public static void main(String[] args) {
        var a = new myList<>();

        a.delHead();
        System.out.println();

        a.addHead('a');
        a.addHead(true);
        a.addHead(12);
        a.addHead(12);
        a.addHead(12);
        a.addHead("shdsadfs");
        a.addTail("asdf");
        a.addTail(12);
        a.addHead(346.34);
        a.addTail(12);
        a.addTail(12);
        a.addHead(12);
        a.addHead(12);
        a.addHead(12);

        var b = new myList<>(a);
        System.out.println(b.getClass().getName());

        a.printList();
        System.out.println(a.getSize());
        System.out.println();

        a.delAll();
        a.printList();
        System.out.println(a.getSize());
        a.delFirstByValue("asd");
        a.addTail(3);
        a.delHead();
        System.out.println();

        b.delHead();
        b.printList();
        System.out.println(b.getSize());
        System.out.println();

        b.delFirstByValue("12");
        b.printList();
        System.out.println(b.getSize());
        b.delFirstByValue("asdf");
        b.delFirstByValue(12);
        b.delFirstByValue(12);
        b.delFirstByValue(12);
        b.delFirstByValue(12);
        b.delFirstByValue(12);
        b.delFirstByValue(12);
        b.delFirstByValue(12);
        b.delFirstByValue(12);
        b.printList();
        System.out.println(b.getSize());
        b.delFirstByValue("asd");
        System.out.println();

        var c = new myList<>();

        c.addTail(1);
        c.addTail(2);
        c.addTail(1);

        c.delFirstByValue(1);
        c.printList();
        System.out.println(c.getSize());
        System.out.println();

        var e = new myList<>();

        e.addHead(0x16);
        e.addHead(0x16);

        e.delFirstByValue(0x16);
        e.delFirstByValue(0x16);
        e.printList();
        System.out.println(e.getSize());
    }
}
