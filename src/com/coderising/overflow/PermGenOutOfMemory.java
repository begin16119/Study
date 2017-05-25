package com.coderising.overflow;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/** VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by wang on 2017/5/19.
 */
public class PermGenOutOfMemory {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<String>();
//        int i = 0;
//
//        while(true){
//            list.add(String.valueOf(i++).intern());
//        }
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2 = new StringBuilder("ma").append("in").toString();
//        System.out.println(str2.intern() == str2);

        while(true){

            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
                    enhancer.create();
        }



    }
    static class OOMObject{

    }


}
