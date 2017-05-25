package com.dataStructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 用Queue来实现Josephus问题
 * 在这个古老的问题当中， N个深陷绝境的人一致同意用这种方式减少生存人数：  N个人围成一圈（位置记为0到N-1）， 并且从第一个人报数， 报到M的人会被杀死， 直到最后一个人留下来
 * 该方法返回一个List， 包含了被杀死人的次序
 * @author liuxin
 *
 */
public class Josephus {
	
	public static List<Integer> execute(int n, int m){		

		List<Integer> deathOrder = new ArrayList<>();
		Queue<Integer> livePeople = new Queue<>();

		for(int i=0; i<n; i++){
			livePeople.enQueue(i);
		}
		int x = 0;
		while(!livePeople.isEmpty()){
			int num = livePeople.deQueue();
			if(x % m == 0){
				deathOrder.add(num);
			}else{
				livePeople.enQueue(num);
			}

		}
		return deathOrder;
	}
	
}
