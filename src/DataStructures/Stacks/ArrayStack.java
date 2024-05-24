package DataStructures.Stacks;

public class ArrayStack implements Stack {
    private int[] Stack;
    private final int capacity;
    private int top;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        Stack = new int[capacity];
        top = -1;
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
    public void push(int value) throws Exception {
        if (isFull()) {
            throw new Exception("overflow");
        }
        else {
            Stack[++top] = value;
        }
    }

    @Override
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("underflow");
        }
        else {
            return Stack[top--];
        }
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
