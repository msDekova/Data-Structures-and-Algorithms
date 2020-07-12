/// You have an empty sequence, and you will be given N queries. Each query is one of these three types:
/// 1 x  -Push the element x into the stack.
//  2    -Delete the element present at the top of the stack.
//  3    -Print the maximum element in the stack.

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfQueries = scanner.nextInt();
        int query;
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> sortStack = new PriorityQueue<>(new ChangePriority());

        while (numOfQueries-- > 0) {
            query = scanner.nextInt();
            switch (query) {
                //// Push the element x into the stack.
                case 1: {
                    int x = scanner.nextInt();
                    stack.push(x);
                    sortStack.add(x);
                    break;
                }
                //// Delete the element present at the top of the stack.
                case 2: {
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty");
                    }
                    int del = stack.pop();
                    sortStack.remove(del);
                    break;
                }
                //// Print the maximum element in the stack.
                case 3: {
                    System.out.println(sortStack.peek());
                }
            }
        }
    }
}

class ChangePriority implements Comparator<Integer>{
    @Override
    public int compare(Integer a1, Integer a2){
        if(a1<a2){
            return 1;
        } else if(a2<a1){
            return -1;
        }
        return 0;
    }
}