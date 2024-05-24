package DataStructures.Stacks;

class Node{
    int key;
    Node next;
    Node prev;
    public Node(int key){
        this.key = key;
        next = null;
        prev = null;
    }
}
public class LinkedList {
    private Node head;
    public LinkedList(){
        this.head = null;
    }

    public Node search(int key){
        Node x = head;
        while(x != null && x.key != key){
            x = x.next;
        }
        return x;
    }

    // Method to insert a new node from left side
    public void insertFirst(int key){
        // Create a new node with given data
        Node x = new Node(key);
        // If the Linked List is empty, then make the new node as head
        if (head != null) {
            head.prev = x;
        } else {
            // Insert the new node as the first node
            x.next = head;
            x.prev = null;
            head = x;
        }
    }

    // Method to insert a new node from right side
    public void insertLast(int key){
        // Create a new node with given data
        Node x = new Node(key);
        // If the Linked List is empty, then make the new node as head
        if (head != null) {
            head.prev = x;
        } else { // Traverse till the last node and insert the new node there
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = x;
        }
    }

    public void delete(int key){
        Node x = search(key);
        if (x.prev != null) {
            x.next.prev = x.prev;
        } else {
            head = x.next;
        }
        if (x.next != null) {
            x.prev.next = x.next;
        }
    }
    public void printList(){
        Node x = head;
        while (x != null) {
            System.out.print(x.key + "");
            x = x.next;
        }
    }

}
