/* Class node is defined as :
class Node
    int val;	//Value
    int ht;		//Height
    Node left;	//Left child
    Node right;	//Right child

*/

static int height(Node node) {
        return node == null ? -1 : node.ht;
        }

static int getBalance(Node node) {
        return node == null ? 0 : height(node.right) - height(node.left);
        }

static void updateHeight(Node node) {
        int height= Math.max(height(node.left), height(node.right));
        node.ht=height+1;
        }

static Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;

        x.right = y;
        y.left = z;

        updateHeight(x);
        updateHeight(y);
        return x;
        }

static Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;

        x.left = y;
        y.right = z;

        updateHeight(y);
        updateHeight(x);
        return x;
        }

static Node fixBalance(Node node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
        if (height(node.right.right) > height(node.right.left)) {
        node = rotateLeft(node);
        } else {
        node.right = rotateRight(node.right);
        node = rotateLeft(node);
        }
        } else if (balance < -1) {
        if (height(node.left.left) > height(node.left.right))
        node = rotateRight(node);
        else {
        node.left = rotateLeft(node.left);
        node = rotateRight(node);
        }
        }
        return node;
        }
static Node insert(Node curr,int val)
        {
        if (curr == null) {
        Node newNode=new Node();
        newNode.val=val;
        return newNode;
        }

        if (curr.val < val) {
        curr.right = insert(curr.right, val);
        } else if (curr.val > val) {
        curr.left = insert(curr.left, val);
        }
        return fixBalance(curr);
        }