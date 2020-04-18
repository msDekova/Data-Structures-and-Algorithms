import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    Node root;

    BST() {
        root = null;
    }

    public void insert(int x) {
        root = _insert(root, x);
    }

    private Node _insert(Node curr, int data) {
        if (curr == null) {
            Node newNode = new Node(data);
            return newNode;
        }

        if (curr.value < data)
            curr.right = _insert(curr.right, data);
        else if (curr.value > data)
            curr.left = _insert(curr.left, data);

        return curr;
    }

    public void isExist(int x) {
        if (_isExist(root, x)) System.out.println(x + " is in the bst.");
        else System.out.println(x + " is not in the bst.");
    }

    private boolean _isExist(Node curr, int data) {
        if (curr == null) {
            return false;
        }

        if (curr.value < data)
            return _isExist(curr.right, data);
        else if (curr.value > data)
            return _isExist(curr.left, data);

        return true;
    }

    public void remove(int x) {
        root = _remove(root, x);
    }

    private Node _remove(Node curr, int data) {
        if (curr == null) {
            return null;
        }

        if (curr.value < data)
            curr.right = _remove(curr.right, data);
        else if (curr.value > data)
            curr.left = _remove(curr.left, data);
        else {  ///curr.value==data
            if (curr.left == null && curr.right == null)
                return null;
            else if (curr.right == null)
                return curr.left;
            else if (curr.left == null)
                return curr.right;
            else {
                Node swapWith = curr.right;
                while (swapWith.left != null) {
                    swapWith = swapWith.left;
                }

                curr.value = swapWith.value;
                curr.right = _remove(curr.right, swapWith.value);
            }
        }
        return curr;
    }

    public void inorder() {
        _inorder(root);
        System.out.println();
    }

    private void _inorder(Node curr) {
        if (curr != null) {
            _inorder(curr.left);
            System.out.print(curr.value + " ");
            _inorder(curr.right);
        }
        return;
    }

    public void preorder() {
        _preorder(root);
        System.out.println();
    }

    private void _preorder(Node curr) {
        if (curr != null) {
            System.out.print(curr.value + " ");
            _preorder(curr.left);
            _preorder(curr.right);
        }
        return;
    }

    public void postorder() {
        _postorder(root);
        System.out.println();
    }

    private void _postorder(Node curr) {
        if (curr != null) {
            _preorder(curr.left);
            _preorder(curr.right);
            System.out.print(curr.value + " ");
        }
        return;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(6);

        bst.inorder();      //inorder traversal
        bst.preorder();     //preorder traversal
        bst.postorder();    //postorder traversal
        bst.remove(4);   //remove 4 from the bst
        bst.isExist(7);
    }
}
