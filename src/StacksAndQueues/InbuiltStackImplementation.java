package StacksAndQueues;

import java.util.Stack;

public class InbuiltStackImplementation {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(43);
        stack.add(21);
        stack.pop();
        System.out.println(stack.peek());
    }
}
