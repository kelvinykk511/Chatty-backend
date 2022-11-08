package com.kelvinykk511.chatty.controller;

import com.kelvinykk511.chatty.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * @author Kelvin Yang
 * @datetime 7/11/2022 5:17 pm
 */
@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receivePublicMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getRecceiverName(), "/private", message);
        return message;
    }

    @MessageMapping("/group-message")
    public Message receiveGroupMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getRecceiverName(), "/private", message);
        return message;
    }
}
