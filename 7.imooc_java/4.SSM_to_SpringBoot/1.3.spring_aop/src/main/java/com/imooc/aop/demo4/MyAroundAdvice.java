package com.imooc.aop.demo4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕前增强===================");

        //执行目标方法
        Object obj = invocation.proceed();

        System.out.println("环绕后增强===================");
        return obj;
    }
}
