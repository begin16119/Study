package com.coderising.overflow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2017/5/19.
 */

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class OutOfMemory {

    public static void main(String[] args) {

        List list = new ArrayList();
        while(true){
            list.add(1);
        }
    }

}


