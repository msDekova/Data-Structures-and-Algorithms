///In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, S.
// You must perform  operations of the following  types:
//1. append(W) - Append string W to the end of S.
//2. delete(k) - Delete the last k characters of S.
//3. print(k) - Print the k character of S.
//4. undo() - Undo the last (not previously undone) operation of type 1 or 2, reverting S to the state it was in prior
// to that operation.

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    static StringBuffer input;
    static Stack<String> strContainer = new Stack<>();

    static void appendStr(String str){
        input.append(str);
        strContainer.push(input.toString());
    }
    static void deleteKElements(int k){
        input = input.delete(input.length()-k,input.length());
        strContainer.push(input.toString());
    }

    static void print(int k){
        if(k>input.length()) return;
        System.out.println(input.charAt(k-1));
    }

    static void undo(){
        strContainer.pop();
        input.replace(0,input.length(),strContainer.peek());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        input = new StringBuffer("");
        strContainer.push("");
        int numOfQueries = scanner.nextInt();
        while(numOfQueries-->0){
            int query = scanner.nextInt();
            switch (query){
                case 1:{
                    String str = scanner.next();
                    appendStr(str);
                    break;
                }
                case 2:{
                    int k = scanner.nextInt();
                    deleteKElements(k);
                    break;
                }
                case 3:{
                    int k = scanner.nextInt();
                    print(k);
                    break;
                }
                case 4:{
                    undo();
                }
            }
        }



        scanner.close();
    }
}
