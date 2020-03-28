import java.util.Stack;

class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    /* The method insert to push element
       into the queue */
    void insert(int B) {
        // Your code here
        s1.push(B);
    }


    /* The method remove which return the
      element popped out of the queue*/
    int remove() {
        // Your code here
        if (s1.isEmpty()) return -1;

        while (!s1.isEmpty()) {
            s2.push(s1.peek());
            s1.pop();
        }
        int ans = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.peek());
            s2.pop();
        }
        return ans;
    }
}

