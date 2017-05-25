package com.dataStructure.expr;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wang on 2017/4/18.
 */
public class InfixToPostfix {
    public static List<Token> convert(String expr) {
        TokenParser parser = new TokenParser();
        List<Token> infixExpr = parser.parse(expr);
        List<Token> postfixExpr = new ArrayList<>();

        Stack<Token> opt = new Stack<>();

        for (Token token : infixExpr) {
            if(token.isNumber()){
                postfixExpr.add(token);
            }else if(token.isOperator()){
                if(opt.isEmpty()){
                    opt.push(token);
                }else{
                    if(token.hasHigherPriority(opt.peek())){
                        opt.push(token);
                    }else {
                        while(!opt.isEmpty()){
                            postfixExpr.add(opt.pop());
                        }
                        opt.push(token);
                    }
                }
            }
        }

        while(!opt.isEmpty()){
            postfixExpr.add(opt.pop());
        }


        return postfixExpr;
    }

}
