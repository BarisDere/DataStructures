package com.barisdere.datastructures.queues;

public class MyQueue<T> {

    private final int maxSize;
    private int numberOfItems;
    private int front;
    private int rear;
    private T arr[];

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = (T[]) new Object[maxSize];
    }

    public void enqueue(T value) {
        if (numberOfItems == maxSize) {
            throw new RuntimeException("Sorry queue is full");
        }
        rear = (rear+1) % maxSize;
        arr[rear] = value;
        numberOfItems++;
    }

    public T dequeue() {
        if (numberOfItems == 0) {
            return null;
        }
        numberOfItems--;
        front = (front+1) % maxSize;
        return arr[front];
    }

    public T peek() {
        if (numberOfItems == 0) {
            return null;
        }
        int peekIndex = (front+1) % maxSize;
        return arr[peekIndex];
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
}
