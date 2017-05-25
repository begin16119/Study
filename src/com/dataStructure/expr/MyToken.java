package com.dataStructure.expr;

/**
 * Created by wang on 2017/4/14.
 */
public class MyToken {
    public static final int  OPERATOR = 0;
    public static final int  NUMBER = 1;
    private int type ;
    private String value;
    public MyToken(int type, String value) {
        this.type = type;
        this.value = value;
    }



    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
