public static void levelOrder(Node root){
        if(root==null)return;
        Deque<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();

            while(size-->0){
                Node curr=q.peekFirst();
                System.out.print(curr.data+" ");
                if(curr.left!=null)q.addLast(curr.left);
                if(curr.right!=null)q.addLast(curr.right);
                q.removeFirst();
            }
        }
}