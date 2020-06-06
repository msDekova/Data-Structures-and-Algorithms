import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static int[] dLeftRotation(int[] arr, int d){
        int[] ans = new int[arr.length];
        int begin=arr.length-d;
        int j=0,i=0;
        while(begin<arr.length){
            ans[begin]=arr[j];
            begin++;
            j++;
        }
        while(j<arr.length && i<d){
            ans[i]=arr[j];
            i++;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=scanner.nextInt();
        int d=scanner.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        scanner.close();

        int[] retArr=dLeftRotation(arr,d);
        for(int i=0;i<retArr.length;i++){
            System.out.print(retArr[i]+" ");
        }
    }
}
