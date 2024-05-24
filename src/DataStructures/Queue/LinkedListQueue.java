package DataStructures.Queue;

import java.util.NoSuchElementException;

class Node {
    int key;
    Node next;
    public Node(int key){
        this.key = key;
        this.next = null;
    }
}

public class LinkedListQueue {
    private Node front;
    private Node rear;
    private int size;

    public LinkedListQueue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int key){
        Node newNode = new Node(key);
        if(isEmpty()){
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        int key = front.key;
        front = front.next;
        return key;
    }
}
