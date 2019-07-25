package com.itheima.demo10.WaitAndNotify;

/*
notify() and notifyall()的区别
 */
public class Demo03WaitAndNotify {

    public static void main(String[] args) {
        Object obj = new Object();

        //创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                while(true){
                    synchronized (obj){
                        System.out.println("顾客1:告知老板要的包子的种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客1:包子已经做好了,开吃!");
                    }
                }
            }
        }.start();

        //创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                while(true){
                    synchronized (obj){
                        System.out.println("顾客2:告知老板要的包子的种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("顾客2:包子已经做好了,开吃!");
                    }
                }
            }
        }.start();


        //创建一个老板线程(生产者)
        new Thread(){
            @Override
            public void run() {
                //一直做包子
                while (true){
                    //花了5秒做包子
                    try {
                        Thread.sleep(5000);//花5秒钟做包子
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //保证等待和唤醒的线程只能有一个执行,需要使用同步技术
                    synchronized (obj){
                        System.out.println("老板5秒钟之后做好包子,告知顾客,可以吃包子了");
                        System.out.println("=====================================");
                        //做好包子之后,调用notify方法,唤醒顾客吃包子
                        //obj.notify();
                        obj.notifyAll();
                    }
                }
            }
        }.start();


    }



}



