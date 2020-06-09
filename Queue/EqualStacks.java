// You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height.
// You can change the height of a stack by removing and discarding its topmost cylinder any number of times.
// Find the maximum possible height of the stacks such that all of the stacks are exactly the same height.
// This means you must remove zero or more cylinders from the top of zero or more of the three stacks until
// they're all the same height, then print the height. The removals must be performed in such a way as to maximize
// the height.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EqualStacks {
    public static Scanner scanner = new Scanner(System.in);
    private static Queue<Integer> q1 = new LinkedList<>();
    private static Queue<Integer> q2 = new LinkedList<>();
    private static Queue<Integer> q3 = new LinkedList<>();

    public static void main(String[] args) {
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();


        int height1 = input(q1, n1, 0);
        int height2 = input(q2, n2, 0);
        int height3 = input(q3, n3, 0);

        while (!(height1 == height2 && height2 == height3)) {
            if (q1.isEmpty() || q2.isEmpty() || q3.isEmpty()) {
                height1 = 0;
                break;
            }
            if (height1 >= height2 && height1 >= height3) {
                height1 -= q1.peek();
                q1.poll();
            } else if (height2 >= height1 && height2 >= height3) {
                height2 -= q2.peek();
                q2.poll();
            } else if (height3 >= height1 && height3 >= height2) {
                height3 -= q3.peek();
                q3.poll();
            }
        }
        System.out.println(height1);
    }

    static int input(Queue<Integer> q, int n, int height) {
        int num;
        for (int i = 0; i < n; i++) {
            num = scanner.nextInt();
            q.add(num);
            height += num;
        }
        return height;
    }
}
