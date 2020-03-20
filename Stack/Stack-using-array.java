public class Stack {
    int capacity;
    int data[];
    int top;

    Stack(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        top = -1;
    }

    void push(int value) {
        if (top >= capacity - 1) {
            System.out.println("Stack overflow.");
            return;
        }
        top++;
        data[top] = value;
    }

    void pop(){
        if(top<0){
            System.out.println("Stack underflow.");
            return;
        }

        top--;
    }

    boolean isEmpty(){
        return (top<0);
    }

    int peek(){
        if(top<0){
            System.out.println("Stack underflow.");
            return 0;
        }

        return data[top];
    }

    static void print(Stack st){
        while(!st.isEmpty()){
            System.out.print(st.peek()+" ");
            st.pop();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s=new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.peek()); // peek 5
        s.pop(); // pop 5
        System.out.println(s.peek()); // peek 4
        s.pop(); // pop 4
        print(s);
    }
}
