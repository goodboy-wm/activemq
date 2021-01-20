package com.nari.wm.brl.impl;

import com.nari.wm.brl.MqMessage;
import com.nari.wm.entity.Sc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class MqMessageServiceImpl implements MqMessage {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(Destination destination , String message) {
        System.out.println("发送消息:  "+message);
        jmsTemplate.convertAndSend(destination,message);
    }

    @Override
    public void sendMessage(Destination destination, Sc sc) {
        System.out.println("发送消息:  "+sc.toString());
        jmsTemplate.convertAndSend(destination,sc);
    }

    @Override
    @JmsListener(destination ="${spring.jms.template.default-destination}")
    public void getMessage(String message) {
        System.out.println("接收消息：  "+message);
    }

    @Override
    @JmsListener(destination ="scList")
    public void getMessage(Sc sc) {
        System.out.println("消费：  "+sc.toString());
    }

    @Override
    public void sendToppic(Destination destination,String message){
        jmsTemplate.convertAndSend(destination,message);
        System.out.println("发送订阅:  "+message);
    }

    @JmsListener(destination ="mytopic",containerFactory = "mylistenerFactory")
    public void getTopic(String message){
        System.out.println("监听订阅：  "+message);
    }
}
