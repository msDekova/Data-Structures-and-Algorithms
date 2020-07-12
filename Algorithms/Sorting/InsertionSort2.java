import java.util.Scanner;

public class InsertionSort2 {
    // Complete the insertionSort2 function below.
    static void insertionSort2(int n,int[] arr){
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;

            while (j >= 0 && arr[j] > key) {
                arr[j+1]=arr[j];
                j--;

            }
            arr[j+1]=key;
            for(int k=0;k<n;k++){
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n=scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        insertionSort2(n,arr);
        scanner.close();
    }
}
