package com.tp;

import org.springframework.stereotype.Component;

@Component
public class SmsSender implements MessageSender {
    public void send(String message) {
        System.out.println("SMS : " + message);
    }
}