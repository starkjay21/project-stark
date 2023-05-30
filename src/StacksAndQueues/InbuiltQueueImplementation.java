package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InbuiltQueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(14);
        queue.add(7);
        queue.add(27);
        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(15);
        deque.addLast(12);
        deque.addFirst(10);
        System.out.println(deque);

    }
}
