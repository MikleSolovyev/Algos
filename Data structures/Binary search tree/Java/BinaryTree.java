class Node<E> {
    int key;
    E data;
    Node<E> leftNode;
    Node<E> rightNode;

    Node(int key, E data) {
        this.key = key;
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    Node(int key, E data, Node<E> leftNode, Node<E> rightNode) {
        this.key = key;
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    Node<E> copyFromNode() {
        Node<E> leftNode = null;
        Node<E> rightNode = null;

        if (this.leftNode != null) {
            leftNode = this.leftNode.copyFromNode();
        }
        if (this.rightNode != null) {
            rightNode = this.rightNode.copyFromNode();
        }

        return new Node<>(key, data, leftNode, rightNode);
    }
}

public class BinaryTree<E> {

    private Node<E> root;
    private int nodeCount;

    public BinaryTree() {
        this.root = null;
        this.nodeCount = 0;
    }

    public BinaryTree(BinaryTree<E> tree) {
        this.root = tree.root.copyFromNode();
        this.nodeCount = tree.nodeCount;
    }

    public Node<E> getRoot() {
        return root;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void insertNode(int key, E data) {
        Node<E> newNode = new Node<>(key, data);

        if (root == null) {
            root = newNode;
            nodeCount++;
        } else {
            Node<E> currentNode = root;
            Node<E> parentNode;

            while (true) {
                parentNode = currentNode;

                if(key == currentNode.key) {
                    currentNode.data = data;
                    return;
                } else  if (key < currentNode.key) {
                    currentNode = currentNode.leftNode;

                    if (currentNode == null) {
                        parentNode.leftNode = newNode;
                        nodeCount++;

                        return;
                    }
                } else {
                    currentNode = currentNode.rightNode;

                    if (currentNode == null) {
                        parentNode.rightNode = newNode;
                        nodeCount++;

                        return;
                    }
                }
            }
        }
    }

    public Node<E> findNode(int key) {
        Node<E> currentNode = root;

        while (currentNode.key != key) {
            if (key < currentNode.key) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }

            if (currentNode == null) {
                return null;
            }
        }

        return currentNode;
    }

    public void findNodeData(int key) {
        Node<E> currentNode = findNode(key);

        System.out.println(currentNode == null ? "No Node with this key" : currentNode.data);
    }

    public void clear() {
        root = null;
        nodeCount = 0;
    }

    public void preOrderTraversal() {
        System.out.print("[ ");
        preOrder(root);
        System.out.println("]");
    }

    private void preOrder(Node<E> currentNode) {
        if (currentNode == null)
            return;

        System.out.print(currentNode.key + ":" + currentNode.data + " ");

        preOrder(currentNode.leftNode);
        preOrder(currentNode.rightNode);
    }

    public void deleteNode(int key) {
        nodeCount--;
        root = deleteRecursively(root, key);
    }
    
    private Node<E> deleteRecursively(Node<E> currentNode, int key) {
        if (currentNode == null) {
            nodeCount++;

            return currentNode;
        }

        if (key < currentNode.key) {
            currentNode.leftNode = deleteRecursively(currentNode.leftNode, key);
        } else if (key > currentNode.key) {
            currentNode.rightNode = deleteRecursively(currentNode.rightNode, key);
        } else {
            if (currentNode.leftNode == null) {
                return currentNode.rightNode;
            } else if (currentNode.rightNode == null)
                return currentNode.leftNode;

            currentNode.key = findInOrderSuccessor(currentNode.rightNode);
            currentNode.rightNode = deleteRecursively(currentNode.rightNode, currentNode.key);
        }

        return currentNode;
    }

    private int findInOrderSuccessor(Node<E> currentNode) {
        int minimum = currentNode.key;

        while (currentNode.leftNode != null) {
            minimum = currentNode.leftNode.key;
            currentNode = currentNode.leftNode;
        }

        return minimum;
    }
}
