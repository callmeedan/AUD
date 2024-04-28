package DataStructures;

public interface Stack {
    boolean isEmpty();
    boolean isFull();
    void push(int value) throws Exception;
    int pop() throws Exception;
    int peek() throws Exception;
    void printStack();
}
