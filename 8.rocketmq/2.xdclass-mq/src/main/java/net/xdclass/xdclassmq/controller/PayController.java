package net.xdclass.xdclassmq.controller;

import net.xdclass.xdclassmq.jms.PayProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PayController {

    @Autowired
    private PayProducer payProducer;

    private static  final String topic = "xdclass_pay_test_topic";

    //测试方法:
    //http://127.0.0.1:8080/api/v1/pay_cb?text=yyyyyyyybbbx
    //报错:No route info of this topic, xdclass_pay_test_topic2
    @RequestMapping("/api/v1/pay_cb")
    public Object callback(String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        Message message = new Message(topic,"taga", ("hello xdclass rocketmq = "+text).getBytes() );

        SendResult sendResult = payProducer.getProducer().send(message);
        System.out.println(sendResult);

        return new HashMap<>();
    }
}
