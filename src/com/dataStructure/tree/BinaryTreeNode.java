package com.dataStructure.tree;

public class BinaryTreeNode<T> implements Comparable{
	
	 T data;
	 BinaryTreeNode<T> left;
	 BinaryTreeNode<T> right;

	private BinaryTreeNode<T> root;
	
	public BinaryTreeNode(T data){
		this.data=data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	public BinaryTreeNode<T> insert(T o){

		if(o == null){
			throw new NullPointerException("o is null !");
		}

		BinaryTreeNode<T> newNode = null;

		if(root == null){
			root = new BinaryTreeNode<>(o);

		}else{
			newNode = new BinaryTreeNode<>(o);

			int result = newNode.compareTo(root);

			if(result < 0){

				if(root.left==null){
					root.setLeft(newNode);
				}else{
					root = root.left;
					insert(o);
				}


			}else if(result > 0){

				if(root.right==null){
					root.setRight(newNode);
				}else{
					root = root.right;
					insert(o);
				}

			}else {
				throw new RuntimeException("Not support repeated number !");
			}

		}

		return  newNode;
	}

	@Override
	public int compareTo(Object o) {
		if( o == null){
			throw new NullPointerException("object is null");
		}
		return ((Integer)root.data - (Integer) o);
	}
}
