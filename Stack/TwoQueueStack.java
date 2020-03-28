import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /*The method pop which return the element poped out of the stack*/
    int pop() {
        // Your code here
        if (q1.isEmpty()) return -1;

        int ans = q1.peek();
        q1.poll();
        return ans;
    }

    /* The method push to push element into the stack */
    void push(int a) {
        // Your code here
        q2.add(a);
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.poll();
        }

        while (!q2.isEmpty()) {
            q1.add(q2.peek());
            q2.poll();
        }
    }
}
