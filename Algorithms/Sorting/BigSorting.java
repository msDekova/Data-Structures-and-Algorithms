///Consider an array of numeric strings where each string is a positive number with anywhere from  to  digits.
// Sort the array's elements in non-decreasing, or ascending order of their integer values and print each element of
// the sorted array on a new line.

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        String[] arrOfIntegers = new String[size+1];
        for (int i = 0; i < size+1; i++) {
            arrOfIntegers[i] = scanner.nextLine();
        }

        Arrays.sort(arrOfIntegers, new MyComparator());

        for (int i=1;i<size+1;i++) {
            System.out.println(arrOfIntegers[i]);
        }


        scanner.close();
    }
}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2);
        }
        return s1.length() - s2.length();
    }
}