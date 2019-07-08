package com.itheima.demo01.Exception;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
    throws关键字:异常处理的第一种方式,交给别人处理
    作用:
        当方法内部跑出异常的时候,我们就必须处理这个异常对象
        可以使用throw关键字处理异常对象,会把异常声明跑出给调用者处理，最终交给JVM处理-->中断处理
    格式:
        修饰符 返回值 方法名(参数列表) throws AAAException, BBBException{
            throw new AAAException("原因1");
            throw new BBBException("原因2");
        }
    注意:
        1.throws 必须写在方法声明处
        2.throws 关键字后边声明的异常必须是Exception或者Exception子类
        3.方法内部如果抛出了多个异常对象,那么throws后必须是多个异常
          如果抛出的异常对象有子父类关系,那么直接声明父类异常即可
        4.调用了一个声明抛出的方法，我们就必须处理声明的异常
          要么继续使用throws抛出异常,交给方法的调用者处理,最终交给JVM
          要么try...catch自己处理异常
*/

public class Demo05Throws {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //readFile("/tmp/a.txt");
        readFile("/tmp/b.txt");
        //readFile("/tmp/b.html");

    }

    //对路径进行 进行合法性判断
    //FileNotFoundException不用声明, 因为它是IOException的子类
    public static void readFile(String fileName) throws FileNotFoundException, IOException {

        if (!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }

        if (!fileName.equals("/tmp/a.txt")){
            throw new FileNotFoundException("传递的路径有问题");
        }

        System.out.println("路径没有问题,读取文件");
    }
}
