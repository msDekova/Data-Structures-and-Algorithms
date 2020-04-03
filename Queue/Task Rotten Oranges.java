/*
Given a matrix of dimension r*c where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

So, we have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. If it is impossible to rot every orange then simply return -1.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains two integers r and c, where r is the number of rows and c is the number of columns in the array a[]. Next line contains space separated r*c elements each in the array a[].

Output:
Print an integer which denotes the minimum time taken to rot all the oranges (-1 if it is impossible).

Constraints:
1 <= T <= 100
1 <= r <= 100
1 <= c <= 100
0 <= a[i] <= 2

Example:
Input:
2
3 5
2 1 0 2 1 1 0 1 2 1 1 0 0 2 1
3 5
2 1 0 2 1 0 0 1 2 1 1 0 0 2 1

Output:
2
-1
 */

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] arr = new int[rows][cols];
            Queue<Point> q = new LinkedList<>();
            int count=0;

            for (int i = 0; i < rows; i++) {
                for(int j=0;j<cols;j++) {
                    int x = scanner.nextInt();
                    arr[i][j] = x;
                    if (x != 0) count++;
                    if (x == 2) q.add(new Point(i,j));
                }
            }
            int countDays=0;
            int rotten=0;
            while (!q.isEmpty()) {
                int size=q.size();
                rotten+=size;
                while (size>0) {
                    Point orange = q.poll();

                    int r=orange.x;
                    int c=orange.y;

                    if(r+1<rows && arr[r+1][c]==1){
                        q.add(new Point(r+1,c));
                        arr[r+1][c]=2;
                    }
                    if(r-1>=0 && arr[r-1][c]==1){
                        q.add(new Point(r-1,c));
                        arr[r-1][c]=2;
                    }
                    if(c+1<cols && arr[r][c+1]==1){
                        q.add(new Point(r,c+1));
                        arr[r][c+1]=2;
                    }
                    if(c-1>=0 && arr[r][c-1]==1){
                        q.add(new Point(r,c-1));
                        arr[r][c-1]=2;
                    }

                    size--;
                }
                countDays++;
            }
            if(rotten==count) System.out.println(countDays-1);
            else System.out.println("-1");
        }
    }
}

