import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfQueries = scanner.nextInt();

        TreeSet<Integer> heap = new TreeSet<>();

        scanner.nextLine();
        while (numOfQueries-- > 0) {
            String input = scanner.nextLine();
            int query = Integer.parseInt(input.split(" ")[0]);
            if (query == 1 || query == 2) {
                int v = Integer.parseInt(input.split(" ")[1]);
                /// 1 v -> add an element v to the heap
                if(query==1){
                    heap.add(v);
                } else {
                    /// 2 v -> delete an element v from he heap
                    heap.remove(v);
                }
            } else {
                /// 3 -> print the minimum of all elements in the heap
                System.out.println(heap.first());
            }
        }
        scanner.close();
    }
}
