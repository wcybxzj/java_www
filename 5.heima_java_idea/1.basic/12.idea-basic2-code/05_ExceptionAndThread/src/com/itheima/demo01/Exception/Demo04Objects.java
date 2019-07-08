package com.itheima.demo01.Exception;

import java.util.Objects;

/*
    Obects类中的静态方法
    public static <T> T requireNonNull(T obj):查看指定引用对象不是null。
    源码:
        public static <T> T requireNonNull(T obj) {
            if (obj == null)
                throw new NullPointerException();
            return obj;
        }
 */
public class Demo04Objects {
    public static void main(String[] args) {
        //method1(null);
        method2(null);
        //method3(null);
    }

    public static void method1(Object obj){
        //对传递过来的参数进行合法性判断,判断是否为null
        if(obj == null){
            throw new NullPointerException("传递的对象的值是null,1111");
        }
    }

    public static void method2(Object obj){
        Objects.requireNonNull(obj);
    }

    public static void method3(Object obj){
        Objects.requireNonNull(obj,"传递的对象的值是null,3333");
    }

}
