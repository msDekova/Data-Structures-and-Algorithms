import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;

public class InsertionSort1 {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
       for(int i=1;i<n;i++){
           int key=arr[i];
           int j=i-1;

           while(j>=0 && arr[j]>key){
               arr[j+1]=arr[j];
               j--;
               for(int k=0;k<arr.length;k++){
                   System.out.print(arr[k]+" ");
               }
               System.out.println();
           }
           arr[j+1]=key;

       }
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
