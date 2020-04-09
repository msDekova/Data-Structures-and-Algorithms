class Decoding {

/*
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;

*/

    void decode(String s, Node root) {
        if(root==null) return;

        Node curr=root;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                curr=curr.right;
            } else if(s.charAt(i)=='0'){
                curr=curr.left;
            }

            if(isLeaf(curr)){
                System.out.print(curr.data);
                curr=root;
            }
        }
    }

    private boolean isLeaf(Node curr){
        if(curr.right==null && curr.left==null) return true;
        return false;
    }
}