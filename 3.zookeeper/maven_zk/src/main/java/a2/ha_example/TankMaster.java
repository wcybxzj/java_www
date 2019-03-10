package a2.ha_example;

import org.apache.zookeeper.*;

import java.util.Random;

//使用zookeeper实现:当前正服务的就是ACTIVE,备用的是STANDBY

//测试:
/*
idea1:是ACTIVE
1.main():当前node port:36
3.main():zk中不存在对外服务的znode, 创建znode
6.MasterWatcher->process()执行
4.main():此节点当前状态:ACTIVE
5.main():sleep MAX_VALUE 模拟等待用户进行连接

idea2:是STANDBY
1.main():当前node port:446
2.main():zk中已经存在对外服务的znode
4.main():此节点当前状态:STANDBY
5.main():sleep MAX_VALUE 模拟等待用户进行连接

idea1:结束程序

idea2:可以看到idea2从STANDBY切换成了ACTIVE
6.MasterWatcher->process()执行
7.MasterWatcher->process()发现zk节点变化,当前节点切换为active
*/
public class TankMaster {
    static String status ="ACTIVE";

    public static void main(String[] args) throws Exception{
        String CONN = "192.168.1.178:2181,192.168.1.179:2181,192.168.1.180:2181";
        ZooKeeper zk = new ZooKeeper(CONN, 5000,null);
        String IP = "111.111.111.111";//master ip
        String port = new Random().nextInt(500)+"";//master port
        System.out.println("1.main():当前node port:"+port);

        //判断zk节点是否存在,并且设置watcher对zk的这个节点状态进行监控
        if (zk.exists("/tankmaster", new MasterWatcher())!=null){
            System.out.println("2.main():zk中已经存在对外服务的znode");
            status = "STANDBY";
        }else{
            System.out.println("3.main():zk中不存在对外服务的znode, 创建znode");
            zk.create("/tankmaster", (IP+ ":" +port).getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            status = "ACTIVE";
        }

        System.out.println("4.main():此节点当前状态:"+status);
        System.out.println("5.main():sleep MAX_VALUE 模拟等待用户进行连接");
        Thread.sleep(Integer.MAX_VALUE);
    }

    //当zk被监控的节点状态发生改变的时候执行这个
    //发现zk节点已经不存在了,当前节点切换成active对外进行服务
    static class MasterWatcher implements Watcher{
        public void process(WatchedEvent event) {
            System.out.println("6.MasterWatcher->process()执行");
            if (event.getType() == Event.EventType.NodeDeleted){
                status = "ACTIVE";
                System.out.println("7.MasterWatcher->process()发现zk节点变化,当前节点切换为active");
            }
        }
    }
}
