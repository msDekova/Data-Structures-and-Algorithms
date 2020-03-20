public class StackUsingList {
    StackNode top;

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
            next = null;
        }
    }

    void push(int value) {
        StackNode newNode = new StackNode(value);

        if (top == null) {
            top = newNode;
            return;
        }

        StackNode prev = top;
        top = newNode;
        newNode.next = prev;
    }

    void pop() {
        if (top == null) return;

        StackNode curr = top;
        top = curr.next;
    }

    int peek() {
        if (top == null) return -1;

        return top.data;
    }

    boolean isEmpty() {
        if (top == null) return true;

        return false;
    }

    static void print(StackUsingList st) {
        if (st.top == null) return;

        while (!st.isEmpty()) {
            System.out.print(st.peek() + " ");
            st.pop();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingList s = new StackUsingList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        System.out.println(s.peek()); // peek 6
        s.pop(); // pop 6
        print(s);
    }
}
