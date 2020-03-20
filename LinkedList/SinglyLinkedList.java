public class SinglyLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static SinglyLinkedList insert(SinglyLinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
        return list;
    }

    public static SinglyLinkedList insertFront(SinglyLinkedList list, int data) {
        Node node = new Node(data);

        node.next = list.head;
        list.head = node;

        return list;
    }

    public static SinglyLinkedList insertInPosition(SinglyLinkedList list, int data, int position) {
        Node node = new Node(data);
        if (list.head == null) {
            node.next = list.head;
            list.head = node;
            return list;
        }
        Node currNode = list.head, prevNode = null;
        int counter = 0;
        while (currNode != null && position > counter) {
            prevNode = currNode;
            currNode = currNode.next;
            counter++;
        }

        prevNode.next = node;
        node.next = currNode;

        return list;
    }

    public static SinglyLinkedList deleteByKey(SinglyLinkedList list, int key) {
        if (list.head == null) {
            return null;
        }

        Node currNode = list.head;
        Node prevNode = null;

        //CASE 1 : if the key is found on first position(head)
        if (currNode != null && key == currNode.data) {
            /// the head of the new list
            list.head = currNode.next;
            System.out.println(key + " is found and deleted.");

            return list;
        }

        //CASE 2 : if the key is found between first and the last element of the list
        while (currNode != null && key != currNode.data) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        if (currNode != null) {
            prevNode.next = currNode.next;
            System.out.println(key + " is found and deleted.");

            return list;
        }

        //CASE 3 : if the key is not found
        if (currNode == null) {
            System.out.println(key + " is not found in this list.");
        }

        return list;
    }

    public static SinglyLinkedList deleteByIndex(SinglyLinkedList list, int index) {
        if (list.head == null) {
            return null;
        }

        Node currNode = list.head;
        Node prevNode = null;

        //CASE 1: if index==0;
        if (index == 0) {
            currNode = currNode.next;
            System.out.println("Element at " + index + " position is found and deleted.");
            return list;
        }

        //CASE 2: if index is bigger than 0 and smaller than elements in the list
        int counter = 0;
        while (currNode != null) {
            if (index == counter) {
                prevNode.next = currNode.next;
                System.out.println("Element at " + index + " position is found and deleted.");
                break;
            } else {
                prevNode = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        //CASE 3: if index is bigger than the number of elements in the list
        if (currNode == null) {
            System.out.println("Element with " + index + " is not found in the linked list.");
        }
        return list;
    }

    public static SinglyLinkedList removeDuplicates(Node head) {
        if (head == null) return null;

        Node curr = head, last = head;
        SinglyLinkedList newList = new SinglyLinkedList();
        newList = insert(newList, last.data);
        while (curr != null) {
            if (curr.data != last.data) {
                newList = insert(newList, curr.data);
                last = curr;
            }
            curr = curr.next;
        }

        return newList;
    }

    public static void printList(SinglyLinkedList list) {
        Node currNode = list.head;
        System.out.print("Linked List: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void printRecursively(Node head) {
        if (head == null) return;


        printRecursively(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
        l = insert(l, 1);
        l = insert(l, 3);
        l = insert(l, 4);
        l = insert(l, 5);
        l = insert(l, 7);
        l = insert(l, 7);
        l = insert(l, 8);
        l = insert(l, 9);

        printList(l);

        l = deleteByKey(l, 6);
        printList(l);
        l = deleteByKey(l, 4);
        printList(l);
        l = deleteByKey(l, 9);
        printList(l);

        l = deleteByIndex(l, 2);
        printList(l);
        l = deleteByIndex(l, 8);
        printList(l);
        System.out.println("Insert 6 at the beginning of the Linked List:");
        l = insertFront(l, 6);
        printList(l);
        System.out.println("Insert 4 at position 3.");
        l = insertInPosition(l, 4, 3);
        printList(l);
        System.out.print("Print recursively: ");
        printRecursively(l.head);
        System.out.println();
        System.out.println("Remove duplicates in the list.");
        l = removeDuplicates(l.head);
        printList(l);
    }
}
