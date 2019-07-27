package com.itheima.demo10.WaitAndNotify;

/*
进入TimeWaiting（计时等待）有两种方法
1.使用sleep(long m)方法,在毫秒值结束后,线程睡醒进入到Runable/Blocked状态
2.使用wait(long m),wait超时还没收到notify，则结束阻塞进入到Runable
 */
public class Demo02WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();

        //创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                while(true){
                    synchronized (obj){
                        System.out.println("告知老板要的包子的种类和数量");
                        try {
                            obj.wait(5000);//5 second
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子已经做好了,开吃!");
                        System.out.println("---------------------------------------");
                    }
                }
            }
        }.start();
    }
}



