package com.dataStructure.expr;

import java.util.List;
import java.util.Stack;

/**
 * Created by wang on 2017/4/18.
 */
public class PostfixExpr {
    String expr = null;

    public PostfixExpr(String expr) {
        this.expr = expr;
    }

    public float evaluate() {

        TokenParser parser = new TokenParser();

        List<Token> tokens = parser.parse(expr);

        Stack<Float> val = new Stack<>();

        Stack<String> ops = new Stack<>();
        for(Token token : tokens){
            if(token.isNumber()){
                val.push(token.getFloatValue());
            }else if(token.isOperator()){

                float v2 = val.pop();
                float v1 = val.pop();
                String op = token.toString();

                float result = calculate(op,v1,v2);
                val.push(result);
            }
        }



        return val.peek();
    }

    private float calculate(String ops , float v1 , float v2){
        if(ops.equals("+") ){
            return v1 + v2;
        }else if(ops.equals("-")){
            return v1 - v2;
        }else if(ops.equals("*")){
            return v1 * v2;
        }else if(ops.equals("/")){
            return v1 / v2;
        }else{
            throw new RuntimeException("Not support this operator");
        }
    }


}
