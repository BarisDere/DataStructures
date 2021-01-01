package com.barisdere.datastructures.stacks;

public class MyStack<T> {

    private int maxSize;
    private int top;
    private T arr[];

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.arr = (T[]) new Object[maxSize];
    }

    public void push(T value) {
        if (isFull()) {
            throw new RuntimeException("Sorry stack is full");
        }
        arr[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return arr[top--];
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[top];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == maxSize -1;
    }
}
