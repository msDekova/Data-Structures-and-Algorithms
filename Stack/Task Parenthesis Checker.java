// Given an expression string exp. Examine whether the pairs and the orders of
// “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
// For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}”
// and 'not balanced' for exp = “[(])”

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {
    public static boolean isBalanced(Stack<Character> s){
        int c1=0;
        int c2=0;
        int c3=0;

        while(!s.isEmpty()){
            if(s.peek()==')') c1++;
            else if(s.peek()=='(') c1--;
            else if(s.peek()=='}') c2++;
            else if(s.peek()=='{') c2--;
            else if(s.peek()==']') c3++;
            else if(s.peek()=='[') c3--;

            s.pop();
        }

        if(c1==0 && c2==0 && c3==0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=Integer.parseInt(scanner.nextLine());
        Queue<String> ans=new LinkedList<>();
        while(t-->0){
            String str=scanner.nextLine();
            Stack<Character> tmp=new Stack<>();
            for(int i=0;i<str.length();i++){
                tmp.push(str.charAt(i));
            }


            if(isBalanced(tmp)) ans.add("balanced");
            else ans.add("not balanced");
        }

        while(!ans.isEmpty()){
            System.out.println(ans.peek());
            ans.poll();
        }
    }
}
