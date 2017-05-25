package com.dataStructure.queue;

/**
 * 用数组实现循环队列
 * @author liuxin
 *
 * @param <E>
 */
public class CircleQueue <E> {
	
	private final static int DEFAULT_SIZE = 10;
	
	//用数组来保存循环队列的元素
	private Object[] elementData = new Object[DEFAULT_SIZE] ;

    private int size = 0;
	//队头
	private int front = 0;
	//队尾  
	private int rear = 0;
	
	public boolean isEmpty() {
		return size == 0;
        
    }

    public int size() {
        return size;
    }

    private boolean isFull(){
        return size == DEFAULT_SIZE;
    }

    public void enQueue(E data) {
        if(isFull()){
            throw new RuntimeException("Queue is full !");
        }
        rear = (rear + 1) % elementData.length;
        elementData[rear] = data;
        size ++;

    }

    public E deQueue() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        front = (front + 1) % elementData.length;
        E oldElem = (E) elementData[front];
        elementData[front] = null;
        size --;

        return oldElem;
    }
}
