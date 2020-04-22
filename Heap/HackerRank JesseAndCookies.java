/*
Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value . To do this, Jesse repeatedly
mixes two cookies with the least sweetness. He creates a special combined cookie with:
sweetness  Least sweet cookie    2nd least sweet cookie).
He repeats this procedure until all the cookies in his collection have a sweetness  .
You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness  . Print   if
this isn't possible.
Input Format
The first line consists of integers , the number of cookies and , the minimum required sweetness, separated by a space.
The next line contains  integers describing the array  where  is the sweetness of the  cookie in Jesse's collection.
Constraints



Output Format
Output the number of operations that are needed to increase the cookie's sweetness .
Output  if this isn't possible.
Sample Input
6 7
1 2 3 9 10 12
Sample Output
2
Explanation
Combine the first two cookies to create a cookie with sweetness 1x1 + 2x2  = 5
After this operation, the cookies are 3,5,9,10,12.
Then, combine the cookies with sweetness  and sweetness , to create a cookie with resulting sweetness 1x3 + 2x5 = 13
Now, the cookies are 13.
All the cookies have a sweetness >=7.

Thus,  operations are required to increase the sweetness.
 */


import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCookies = scanner.nextInt();
        int k = scanner.nextInt();
        int cookie;
        PriorityQueue<Integer> sortedCookies = new PriorityQueue<>();
        for (int i = 0; i < numOfCookies; i++) {
            cookie = scanner.nextInt();
            sortedCookies.add(cookie);
        }

        int count = 0;
        while (sortedCookies.size()>1 && sortedCookies.peek() < k) {
            //int sweetness=0;
            count++;

            //sortedCookies.poll();
            //sweetness+=sortedCookies.poll() + 2*sortedCookies.poll();
            // sortedCookies.poll();
            sortedCookies.add(sortedCookies.poll() + 2 * sortedCookies.poll());
        }
        if(sortedCookies.peek()<k){
            System.out.println("-1");
        }
        else{
            System.out.println(count);
        }

    }
}
