package DataStructures.Queue;

public class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int k) {
        if (size == capacity) {
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = k;
        size++;
    }

    public int dequeue() {
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int k = queue[front];
        front = (front + 1) % capacity;
        size--;
        return k;
    }
}
