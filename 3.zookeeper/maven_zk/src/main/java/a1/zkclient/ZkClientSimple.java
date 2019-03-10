package a1.zkclient;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

//简单zk client 例子
public class ZkClientSimple {
    public static void main(String[] args) throws  Exception{
        //zookeeper集群ip,连上任何一个节点都可以
        //String CONN = "192.168.1.178:2181,192.168.1.179:2181,192.168.1.180:2181";

        String CONN = "127.0.0.1:2181";

        //这个zk客户端是非阻塞的,它是立即返回的但是不要一定返回会就成功连接上
        ZooKeeper zk = new ZooKeeper(CONN, 5000,null);
        //粗暴的等待3秒,自认为
        Thread.sleep(3000);

        //insert
        //创建一个EPHEMERAL类型的节点,一旦client与server断开连接
        zk.create("/zk_simple","simple_data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        //select
        byte[] data = zk.getData("/zk_simple", false,null);
        System.out.println(new String(data));

        //delete
        if (zk.exists("/zk_simple", false) != null){
            System.out.println("zk_simple exist!");
            //zk.delete("/zk_simple", -1);
        }

        Thread.sleep(Integer.MAX_VALUE);
        //zk.close();
    }
}
