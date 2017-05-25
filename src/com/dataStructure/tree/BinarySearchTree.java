package com.dataStructure.tree;

public class BinarySearchTree<T extends Comparable> {

    BinaryTreeNode<T> root;

    public BinarySearchTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }


    public T findMin() {

        return findMin(root).getData();
    }

    private BinaryTreeNode<T> findMin(BinaryTreeNode<T> t) {

        if (t == null) {
            return null;
        } else if (t.getLeft() == null) {
            return t;
        }
        return findMin(t.getLeft());
    }

    public T findMax() {

        BinaryTreeNode<T> curr = root;
        while (curr.getRight() != null) {
            curr = curr.getRight();
        }


        return curr.getData();
    }

    public int size() {

        int size = BinaryTreeUtil.preOrderVisit(root).size();
        return size;
    }


    public void makeEmypy() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public int height() {

        return height(root);
    }

    private int height(BinaryTreeNode<T> t){

        if(t == null)
            return 0;
        else
            return 1 + Math.max(height(t.getLeft()),height(t.getRight()));
    }

    public boolean contains(T data) {
        return contains(data, root);
    }


    private boolean contains(T data, BinaryTreeNode<T> t) {

        if (t == null)
            return false;

        int compareResult = myCompare(data, t.getData());

        if (compareResult < 0) {
            return contains(data, t.getLeft());
        } else if (compareResult > 0) {
            return contains(data, t.getRight());
        } else {
            return true;
        }

    }

    private int myCompare(T left, T right) {

        return (int) left.compareTo(right);

    }

    public void insert(T data) {

        insert(data,root);
    }
    private BinaryTreeNode<T> insert(T data,BinaryTreeNode<T> t){

        if(t == null){
            return new BinaryTreeNode<T>(data);
        }

        int compareResult = data.compareTo(t.getData());

        if(compareResult < 0){
            t.setLeft(insert(data,t.getLeft()));
        }else if(compareResult > 0){
            t.setLeft(insert(data,t.getRight()));
        }else {
            //do nothing!
        }
        return t ;
    }

    public void remove(T data) {
        remove(data,root);

    }

    private BinaryTreeNode<T> remove(T data, BinaryTreeNode<T> t) {
        if(t == null ){
            return t;
        }
        int compareResult = data.compareTo(t.getData());

        if(compareResult < 0){
            t.left = remove(data,t.getLeft());
        }else if(compareResult > 0){
            t.right = remove(data,t.getRight());
        }else {
            if (t.getLeft() != null && t.getRight() != null) {
                t.data = findMin(t.getRight()).getData();

                t.right = remove(t.data, t.right);
            } else {
                t = (t.left != null) ? t.left : t.right;

            }
        }
        return t;
    }

}

