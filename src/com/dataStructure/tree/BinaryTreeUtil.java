package com.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUtil {
    /**
     * 用递归的方式实现对二叉树的前序遍历， 需要通过BinaryTreeUtilTest测试
     *
     * @param root
     * @return
     */
    public static <T> List<T> preOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();

        preOrderRecursion(result, root);

        return result;
    }

    private static <T> void preOrderRecursion(List<T> result, BinaryTreeNode<T> root) {

        result.add(root.getData());

        if (root.getLeft() != null) {

            preOrderRecursion(result, root.getLeft());
        }
        if (root.getRight() != null) {

            preOrderRecursion(result, root.getRight());
        }

    }

    /**
     * 用递归的方式实现对二叉树的中遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> inOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();

        inOrderRecursion(result, root);

        return result;
    }

    private static <T> void inOrderRecursion(List<T> result, BinaryTreeNode<T> root) {

        if (root.getLeft() != null) {
            inOrderRecursion(result, root.getLeft());
        }

        result.add(root.getData());

        if (root.getRight() != null) {
            inOrderRecursion(result, root.getRight());
        }



    }

    /**
     * 用递归的方式实现对二叉树的后遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> postOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();
        postOrderRecursion(result,root);
        return result;
    }

    private static <T> void postOrderRecursion(List<T> result, BinaryTreeNode<T> root) {

        if(root.getRight() != null){
            postOrderRecursion(result,root.getRight());
        }

        if(root.getLeft() != null){
            postOrderRecursion(result,root.getLeft());
        }

        result.add(root.getData());

    }

    /**
     * 用非递归的方式实现对二叉树的前序遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> preOrderWithoutRecursion(BinaryTreeNode<T> root) {

        List<T> result = new ArrayList<T>();

        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        BinaryTreeNode<T> currNode = root;


        while(currNode != null || !stack.isEmpty()){

            while(currNode !=null){
                result.add(currNode.getData());
                stack.push(currNode);
                currNode = currNode.getLeft();
            }

            if(!stack.isEmpty()){
                currNode = stack.pop();
                currNode = currNode.getRight();
            }


        }







        return result;
    }

    /**
     * 用非递归的方式实现对二叉树的中序遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> inOrderWithoutRecursion(BinaryTreeNode<T> root) {

        List<T> result = new ArrayList<T>();


        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        BinaryTreeNode<T> currNode = root;

        while( currNode != null || !stack.isEmpty()){

            while(currNode != null){

                stack.push(currNode);
                currNode = currNode.getLeft();

            }

            if(!stack.isEmpty()){

                currNode = stack.pop();
                result.add(currNode.getData());
                currNode = currNode.getRight();

            }


        }


        return result;
    }

}
