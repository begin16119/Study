package com.dataStructure.stack;

import java.util.Arrays;

/**
 * 用一个数组实现两个栈
 * 将数组的起始位置看作是第一个栈的栈底，将数组的尾部看作第二个栈的栈底，
 * 压栈时，栈顶指针分别向中间移动，直到两栈顶指针相遇，则扩容。
 * @author liuxin
 *
 */
public class TwoStackInOneArray {
	private final static int MAX_SIZE = 10;
	Object[] data ;
	private int size1 = 0;
	private int size2 = 0;


	public TwoStackInOneArray(){
		this.data = new Object[MAX_SIZE];
	}

	/**
	 * 向第一个栈中压入元素
	 * @param o
	 */
	public void push1(Object o){
		isNull(o);

		checkRange();
		data[size1++] = o;
	}

	private void checkRange() {
		if(size1 + size2 + 1 == data.length){
			ensureCapacity();
		}
	}

	private void isNull(Object o) {
		if(o == null){
			throw new NullPointerException();
		}
	}

	private void ensureCapacity() {
		Object[] newArray = new Object[MAX_SIZE * 2 -1];

		newArray = Arrays.copyOf(data,data.length);

		data = newArray;

	}

	/**
	 * 从第一个栈中弹出元素
	 * @return
	 */
	public Object pop1(){
		isEmpyt1();

		return data[size1--];
	}

	private void isEmpyt1() {
		if(size1 == 0 ){
			throw new RuntimeException("stack1 is empty!");
		}
	}

	private void isEmpty2(){
		if(size2 == 0){
			throw new RuntimeException("stack2 is empty!");
		}
	}

	/**
	 * 获取第一个栈的栈顶元素
	 * @return
	 */
	
	public Object peek1(){
		isEmpyt1();

		return data[size1];
	}
	/*
	 * 向第二个栈压入元素
	 */
	public void push2(Object o){
		isNull(o);
		checkRange();
		data[10-size2-1] = o;
		size2 ++;
	}
	/**
	 * 从第二个栈弹出元素
	 * @return
	 */
	public Object pop2(){
		isEmpty2();
		Object top = data[10-size2-1];
		size2 --;
		return top;
	}
	/**
	 * 获取第二个栈的栈顶元素
	 * @return
	 */
	
	public Object peek2(){
		isEmpty2();
		return data[10-size2-1];
	}
	
}
