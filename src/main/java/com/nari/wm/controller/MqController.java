package com.nari.wm.controller;

import com.nari.wm.brl.ExportPdfService;
import com.nari.wm.brl.MqMessage;
import com.nari.wm.entity.Sc;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.util.List;

@RestController
public class MqController {
    @Autowired
    private MqMessage mqMessage;
    @Autowired
    private ExportPdfService exportPdfService;

    @GetMapping("/sendMsg")
    public void sendMsg(String msg){
        Destination destination = new ActiveMQQueue("hello");
        mqMessage.sendMessage(destination,"你真好看");
    }

    @GetMapping("/sendTopic")
    public void sendTopic(String msg){
        Destination destination = new ActiveMQTopic("mytopic");
        mqMessage.sendToppic(destination,msg);
    }

    @GetMapping("/sendMsgsList")
    public void sendMsg(){
        Destination destination = new ActiveMQQueue("scList");
        List<Sc> all = exportPdfService.getAll();
        all.stream().forEach((item)->{
            mqMessage.sendMessage(destination,item);
        });

    }


}
