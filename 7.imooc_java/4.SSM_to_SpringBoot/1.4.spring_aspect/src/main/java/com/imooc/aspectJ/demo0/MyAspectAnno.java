package com.imooc.aspectJ.demo0;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面类
 */
//代表这个类是切面
@Aspect
public class MyAspectAnno {
    //让com.imooc.aspectJ.demo1.ProductDao所有方法进行增强
    //@Before(value = "execution(* com.imooc.aspectJ.demo0.ProductDao.*(..)))")

    //只对save方法进行增强
    @Before(value = "execution(* com.imooc.aspectJ.demo0.ProductDao.save(..)))")
    public void before() {
        System.out.println("前置通知==================");
    }



    @AfterReturning(value = "execution(* com.imooc.aspectJ.demo0.ProductDao.update(..)))",returning ="result" )
    public void afterReturning(Object result) {
        System.out.println("后置通知2=================="+ result);
    }

    @Around(value = "execution(* com.imooc.aspectJ.demo0.ProductDao.delete(..)))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前通知");
        Object obj = joinPoint.proceed();//执行目标方法
        System.out.println("环绕后通知");
        return obj;
    }

    //从被怎强的方法捕获异常
    @AfterThrowing(value = "execution(* com.imooc.aspectJ.demo0.ProductDao.findOne(..)))", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("抛出异常=========="+e.getMessage());
    }

    @After(value = "execution(* com.imooc.aspectJ.demo0.ProductDao.findAll(..)))")
    public void after() {
        System.out.println("最终通知==================");
    }


}
