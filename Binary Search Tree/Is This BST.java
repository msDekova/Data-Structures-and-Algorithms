/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
            return check_min_max(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
            }

            boolean check_min_max(Node root, int min, int max){
            if(root!=null){
            if(root.data<=min || root.data>=max){
            return false;
            }
            else {
            return check_min_max(root.left,min,root.data) &&                         check_min_max(root.right,root.data,max);


            }
            }

            return true;
            }