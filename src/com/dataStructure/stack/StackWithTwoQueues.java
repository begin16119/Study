package com.dataStructure.stack;


import com.dataStructure.queue.Queue;

public class StackWithTwoQueues {

    /**
     * queue1 作为主存储
     * queue2 作为辅助存储
     */

    Queue<Integer> queue1 = new Queue<>();
    Queue<Integer> queue2 = new Queue<>();

    private int size = 0;

    public void push(int data) {       
        queue1.enQueue(data);
        size++;
    }

    public int pop() {

        for (int i = 0; i < size - 1; i++) {
            int element = queue1.deQueue();
            queue2.enQueue(element);
        }

        int peek = queue1.deQueue();

        while(!queue2.isEmpty()){
            queue1.enQueue(queue2.deQueue());
        }

        size--;

        return peek;
    }

    
}
