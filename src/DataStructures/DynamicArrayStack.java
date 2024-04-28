package DataStructures;

public class DynamicArrayStack implements Stack {
    private int[] Stack;
    private int capacity;
    private int top;

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        Stack = new int[capacity];
        top = -1;
    }

    public void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];
        System.arraycopy(Stack, 0, newStack, 0, Math.min(Stack.length, newCapacity));
        Stack = newStack;
        capacity = newCapacity;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public boolean isFull() {
        return (top == capacity - 1);
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            resize(capacity * 2);
        }
        Stack[++top] = value;
    }

    @Override
    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("underflow");
        }
        if (top < capacity / 2 && capacity > 2) {
            resize(capacity / 2);
        }
        return Stack[top--];
    }

    @Override
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return Stack[top];
    }

    @Override
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++){
            System.out.print(Stack[i] + " ");
        }
        System.out.println();
    }
}
