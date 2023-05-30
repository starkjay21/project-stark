package StacksAndQueues;

public class MinStackTest {
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        /*
        * ["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
            [[],      [512],[-1024],[-1024],[512],[],[],[],[],[],[]]
        * */
        ms.push(512);
        ms.push(-1024);
        ms.push(-1024);
        ms.push(512);

        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.ss);



    }
}
