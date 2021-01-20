package com.nari.wm.brl;

import com.nari.wm.entity.Sc;

import javax.jms.Destination;

public interface MqMessage  {
    // 发送消息
    void sendMessage(Destination destination,String message);
    // 发送消息
    void sendMessage(Destination destination, Sc sc);
    // 接受消息
    void getMessage(String message);

    void sendToppic(Destination destination,String message);

    void getTopic(String message);

    // 接受对象消息
    void getMessage(Sc sc);

}
