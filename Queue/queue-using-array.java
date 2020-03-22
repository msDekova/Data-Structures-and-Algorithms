public class Queue {
    int capacity;
    int last;
    int[] arr;

    Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        last = 0;
    }

    boolean isFull(Queue queue) {
        return queue.last >= queue.capacity;
    }

    boolean isEmpty(Queue queue) {
        return queue.last <= 0;
    }

    void enqueue(int value) {
        if (isFull(this)) {
            System.out.printf("Queue is full and %d can't be inserted.\n", value);
            return;
        }

        arr[last] = value;
        last++;
    }

    void dequeue() {
        if (isEmpty(this)) {
            System.out.println("Queue is empty.");
            return;
        }

        for (int i = 0; i < last - 1; i++)
            arr[i] = arr[i + 1];

        if (last < capacity)
            arr[last] = 0;

        last--;
    }

    int peek() {
        if (isEmpty(this)) {
            System.out.println("Queue is empty.");
            return Integer.MIN_VALUE;
        }

        return arr[0];
    }

    static void print(Queue queue) {
        if (queue.isEmpty(queue))
            return;

        for (int i = 0; i < queue.last; i++) {
            System.out.print(queue.arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        print(q);
        q.dequeue();
        print(q);
        System.out.println(q.peek());
    }
}
