package com.dev.datastructure.stack;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack(2);
        //Stack stack = new Stack();
        //stack.push(20);
        //stack.push(5);
        System.out.println(stack.pop());
        //stack.getTop();
        //stack.getHeight();
        stack.printStack();
    }
}
