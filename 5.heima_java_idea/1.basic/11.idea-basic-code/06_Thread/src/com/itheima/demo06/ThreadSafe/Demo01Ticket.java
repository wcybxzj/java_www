package com.itheima.demo06.ThreadSafe;
/*
    模拟卖票案例 出现错误,三个线程卖出了重复的票和不存在的票
    创建3个线程,同时开启,对共享的票进行出售
*/

/*
输出:
Thread-2-->正在卖第100张票
Thread-0-->正在卖第100张票
Thread-1-->正在卖第100张票
Thread-2-->正在卖第97张票
Thread-1-->正在卖第97张票
Thread-0-->正在卖第97张票
................
Thread-2-->正在卖第1张票
Thread-0-->正在卖第1张票
Thread-1-->正在卖第-1张票
*/

public class Demo01Ticket {
    public static void main(String[] args) {
        //这里注意为了实现卖票冲突，要用同一个Runable对象
        //创建Runnable接口的实现类对象
        RunnableImpl run = new RunnableImpl();

        //创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t0 = new Thread(run);
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);

        //调用start方法开启多线程
        t0.start();
        t1.start();
        t2.start();
    }
}
