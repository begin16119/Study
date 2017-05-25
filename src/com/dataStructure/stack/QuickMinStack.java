package com.dataStructure.stack;
/**
 * 设计一个栈，支持栈的push和pop操作，以及第三种操作findMin, 它返回改数据结构中的最小元素
 * finMin操作最坏的情形下时间复杂度应该是O(1) ， 简单来讲，操作一次就可以得到最小值
 * @author liuxin
 *
 */



import java.util.Stack;


public class QuickMinStack {
	Stack<Integer> s1 = new Stack<Integer>();
	private int minNum = 0;

	public void push(int data){
		s1.push(data);

		if(data < minNum){
			minNum = data;
		}

	}
	public int pop(){


		return s1.pop();
	}
	public int findMin(){
		return minNum;

	}

	public static void main(String[] args) {
	}
}
