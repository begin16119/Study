package com.coderising.overflow;

/**
 * Created by wang on 2017/5/19.
 */

/**
 * VM Args: -Xss128k
 */
public class StackOverflowError {

    public static void stackOver(){
        stackOver();
    }

    public static void main(String[] args) {
        stackOver();
    }

}
