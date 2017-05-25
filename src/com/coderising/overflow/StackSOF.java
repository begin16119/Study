package com.coderising.overflow;

/**VM Args:-Xss128k
 * Created by wang on 2017/5/21.
 */
public class StackSOF {

    public static void main(String[] args) {

        while(true){
            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }).start();
        }
    }

}
