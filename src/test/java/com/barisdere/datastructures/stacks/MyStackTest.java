package com.barisdere.datastructures.stacks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void shouldPopWhenStackHasValues() {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(2);
        stack.push(4);
        stack.push(98);
        assertThat(stack.pop()).isEqualTo(98);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(2);
    }

    @Test
    void shouldReturnNullWhenStackIsEmpty() {
        MyStack<Integer> stack = new MyStack<>(3);
        assertThat(stack.pop()).isNull();
    }

    @Test
    void shouldFailWhenPushingToAFullStack() {
        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(2);
        stack.push(4);
        stack.push(98);

        assertThatThrownBy(() -> stack.push(100))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Sorry stack is full");
    }

    @Test
    void shouldPeekWhenStackHasValues() {
        MyStack<Integer> stack = new MyStack<>(3);
        assertThat(stack.peek()).isNull();
        stack.push(2);
        stack.push(4);
        assertThat(stack.peek()).isEqualTo(4);
        assertThat(stack.peek()).isEqualTo(4);
        assertThat(stack.peek()).isEqualTo(4);
    }

    @Test
    void shouldAlsoWorkWithStringTypes() {
        MyStack<String> stack = new MyStack<>(3);
        stack.push("Baris");
        stack.push("Dere");
        assertThat(stack.pop()).isEqualTo("Dere");
        assertThat(stack.pop()).isEqualTo("Baris");
    }
}