package com.dataStructure.expr.test; 

import com.dataStructure.expr.InfixToPostfix;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* InfixToPostfix Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 20, 2017</pre> 
* @version 1.0 
*/ 
public class InfixToPostfixTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: convert(String expr) 
* 
*/ 
@Test
public void testConvert() throws Exception {

    String expr = "10-2*3+50";
    String result = InfixToPostfix.convert(expr).toString();
    String expect = "[10, 2, 3, *, -, 50, +]".trim();
    Assert.assertEquals(expect,result);
} 


} 
