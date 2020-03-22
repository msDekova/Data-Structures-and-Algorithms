public class Queue {
    Node front;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    boolean isEmpty(Queue queue) {
        return queue.front == null;
    }

    void enqueue(int value) {
        Node node = new Node(value);

        if (isEmpty(this)){
            front = node;
            return;
        }

        Node curr=front;
        while (curr.next!=null){
            curr=curr.next;
        }

        curr.next=node;
    }

    void dequeue(){
        if(isEmpty(this)){
            System.out.println("Queue is empty.");
        }

        front=front.next;
    }

    int peek(){
        if(isEmpty(this)){
            System.out.println("Queue is empty.");
            return Integer.MIN_VALUE;
        }

        return front.data;
    }

    static void print(Queue queue){
        if(queue.isEmpty(queue)){
            System.out.println("Queue is empty.");
            return;
        }

        Node curr=queue.front;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q=new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        print(q);
        q.dequeue();
        print(q);
        System.out.println(q.peek());
    }
}
