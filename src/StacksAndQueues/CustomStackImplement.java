package StacksAndQueues;

public class CustomStackImplement {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(16);
        stack.push(15);
        stack.push(5);
        stack.push(25);
        stack.push(35);
        stack.push(45);
        stack.push(55);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
