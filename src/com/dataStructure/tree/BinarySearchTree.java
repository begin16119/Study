package com.dataStructure.tree;

import com.dataStructure.queue.Queue;

import java.util.ArrayList;
import java.util.List;

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
        return size(root);
    }


    private int size(BinaryTreeNode<T> t) {
        if (t == null)
            return 0;
        else
            return 1 + size(t.left) + size(t.right);
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

    private int height(BinaryTreeNode<T> t) {

        if (t == null)
            return 0;
        else
            return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
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

        insert(data, root);
    }

    private BinaryTreeNode<T> insert(T data, BinaryTreeNode<T> t) {

        if (t == null) {
            return new BinaryTreeNode<T>(data);
        }

        int compareResult = data.compareTo(t.getData());

        if (compareResult < 0) {
            t.setLeft(insert(data, t.getLeft()));
        } else if (compareResult > 0) {
            t.setLeft(insert(data, t.getRight()));
        }
        return t;
    }

    public void remove(T data) {
        remove(data, root);

    }

    private BinaryTreeNode<T> remove(T data, BinaryTreeNode<T> t) {
        if (t == null) {
            return t;
        }
        int compareResult = data.compareTo(t.getData());

        if (compareResult < 0) {
            t.left = remove(data, t.getLeft());
        } else if (compareResult > 0) {
            t.right = remove(data, t.getRight());
        } else {
            if (t.getLeft() != null && t.getRight() != null) {
                t.data = findMin(t.getRight()).getData();

                t.right = remove(t.data, t.right);
            } else {
                t = (t.left != null) ? t.left : t.right;

            }
        }
        return t;
    }

    public List<T> levelVisit() {
        Queue<BinaryTreeNode> queue = new Queue<>();
        List<T> result = new ArrayList<>();

        queue.enQueue(root);

        BinaryTreeNode currNode = null;

        while (!queue.isEmpty()) {
            currNode = queue.deQueue();
            result.add((T) currNode.data);
            if (currNode.left != null) {
                queue.enQueue(currNode.left);
            }
            if (currNode.right != null) {
                queue.enQueue(currNode.right);
            }

        }

        return result;
    }

    public boolean isValid() {
        return isValid(root);
    }

    private boolean isValid(BinaryTreeNode<T> t) {



        if(t == null){
            throw new NullPointerException();
        }

        Queue<BinaryTreeNode> queue = new Queue<>();
        queue.enQueue(t);
        BinaryTreeNode curr = null ;
        while(!queue.isEmpty()){
            curr = queue.deQueue();
            if(curr.left != null){
                if(curr.compareTo(curr.left) > 0){
                    queue.enQueue(curr.left);
                }else{
                    return false;
                }
            }
            if(curr.right != null){
                if(t.compareTo(curr.right) > 0){
                    queue.enQueue(curr.right);
                }else{
                    return false;
                }
            }


        }

        return true;


    }

    public T getLowestCommonAncestor(T n1, T n2) {
        return getLowestCommonAncestor(root,n1,n2);
    }

    private T getLowestCommonAncestor(BinaryTreeNode<T> root, T n1, T n2) {

        if(root == null)
            throw new NullPointerException();

        int min = n1.compareTo(root.data);
        int max = n2.compareTo(root.data);

        T result = root.data;
        if(min <= 0 && max >= 0){
            return result;
        }

        if(min  > 0 && max > 0 ){
            result = getLowestCommonAncestor(root.right,n1,n2);
        }

        if(min < 0 && max < 0){
            result = getLowestCommonAncestor(root.left,n1,n2);
        }

        return result;
    }

    public List<T> getNodesBetween(T n1, T n2) {
        List<T> result = new ArrayList<>();
        List<T> list = levelVisit();

        for (T t: list) {
            if(t.compareTo(n1) > 0 && t.compareTo(n2) <0 ){
                result.add(t);
            }
        }

        return result;

    }




}

