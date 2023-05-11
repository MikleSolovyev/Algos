public class TestBinaryTree {

    public static void main(String[] args) {
        var a = new BinaryTree<>();
        a.insertNode(45, "a");
        a.insertNode(10, "b");
        a.insertNode(7, "c");
        a.insertNode(12, "d");
        a.insertNode(90, "e");
        a.insertNode(50, "f");

        var b = new BinaryTree<>(a);
        b.insertNode(110, "g");
        a.insertNode(10, 1337);

        a.preOrderTraversal();
        System.out.println(a.getNodeCount());
        System.out.println();

        b.preOrderTraversal();
        System.out.println(b.getNodeCount());
        System.out.println();

        a.findNodeData(10);
        b.findNodeData(120);
        System.out.println();

        b.deleteNode(110);
        b.preOrderTraversal();
        System.out.println(b.getNodeCount());
        System.out.println();

        a.deleteNode(90);
        a.preOrderTraversal();
        System.out.println(a.getNodeCount());
        System.out.println();

        a.deleteNode(90);
        a.preOrderTraversal();
        System.out.println(a.getNodeCount());
        System.out.println();

        a.clear();
        a.preOrderTraversal();
        System.out.println(a.getNodeCount());
        System.out.println();

        b.deleteNode(10);
        b.preOrderTraversal();
        System.out.println(b.getNodeCount());
        System.out.println();

        b.deleteNode(45);
        b.preOrderTraversal();
        System.out.println(b.getNodeCount());
    }
}
