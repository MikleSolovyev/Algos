import java.util.LinkedList;

public class TestQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer, LinkedList<Integer>> q = new PriorityQueue<>();
        System.out.println(q.isEmpty());
        q.remove(1);
        int[] testArray = {81, 74, 65, 45, 40};
        for (int i : testArray) {
            q.add(i);
        }
        q.remove(1);
        q.add(75);
        q.add(80);
        q.add(85);
        q.remove(81);
        q.add(90);
        q.add(73);
        q.add(41);
        q.add(42);
        q.add(46);
        q.remove(85);
        q.print();
        System.out.println(q.isEmpty());
        Integer max = q.getMax();
        System.out.println(max);
        q.add(max);
        q.remove(max);
        q.remove(q.getMax());
        q.remove(q.getMax());
        q.print();
        System.out.println(q.getSize());
    }
}
