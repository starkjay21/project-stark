import java.util.*;

public class StackCollection {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(18);
        stack.push(17);
        stack.push(21);
        stack.push(1);
        stack.push(4);
        stack.push(7);
        stack.push(63);
        stack.push(47);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Stack Empty? "+stack.empty() );
        System.out.println("Stack contains 21? "+stack.search(21));
        System.out.println("StackFirstElement:  "+stack.firstElement() );
        System.out.println("Stack Index of 21: "+stack.indexOf(21) );
        System.out.println("Stack Capacity: "+stack.capacity());
        System.out.println("Peek: "+stack.peek());

        System.out.println(stack);
    }
}
