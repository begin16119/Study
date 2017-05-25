package com.dataStructure.queue;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 * @author liuxin
 *
 * @param <E>
 */
public class QueueWithTwoStacks<E> {
	private Stack<E> stack1;    
    private Stack<E> stack2;    
    private int size = 0;
    
    public QueueWithTwoStacks() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

   
    

    public boolean isEmpty() {

        return stack1.isEmpty();
    }


    
    public int size() {
        return this.size;
    }



    public void enQueue(E item) {
        stack1.push(item);
    }

    public E deQueue() {
        for (int i = 0; i < size - 1; i++) {
            stack2.push(stack1.pop());
        }

        E top = stack1.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return top;
    }



 }

