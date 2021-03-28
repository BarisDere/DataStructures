package com.barisdere.datastructures.queues;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyQueueTest {

    @Test
    void shouldDequeueWhenQueueHasValues() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(4);
        assertThat(queue.dequeue()).isEqualTo(3);
        assertThat(queue.dequeue()).isEqualTo(7);
        assertThat(queue.dequeue()).isEqualTo(4);
    }

    @Test
    void shouldPeekWithoutRemovingValues() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        assertThat(queue.peek()).isNull();
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(4);
        assertThat(queue.peek()).isEqualTo(3);
        assertThat(queue.peek()).isEqualTo(3);
        assertThat(queue.peek()).isEqualTo(3);
    }

    @Test
    void shouldReturnNullWhenQueueIsEmpty() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        assertThat(queue.dequeue()).isNull();
        assertThat(queue.dequeue()).isNull();
        assertThat(queue.dequeue()).isNull();
        assertThat(queue.dequeue()).isNull();
    }

    @Test
    void shouldCalculateNumberOfItems() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(4);
        assertThat(queue.getNumberOfItems()).isEqualTo(3);
        queue.dequeue();
        assertThat(queue.getNumberOfItems()).isEqualTo(2);
    }

    @Test
    void shouldFailWhenEnqueuingIntoAFullQueue() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(4);

        assertThatThrownBy(() -> queue.enqueue(4))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Sorry queue is full");
    }

    @Test
    void shouldEnqueueValueWhenRearIsBeyondQueueLimit() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(2);
        assertThat(queue.peek()).isEqualTo(4);
        assertThat(queue.dequeue()).isEqualTo(4);
        assertThat(queue.dequeue()).isEqualTo(6);
    }
}