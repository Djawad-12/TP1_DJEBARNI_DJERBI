package com.tp;

import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MessageSender {
    public void send(String message) {
        System.out.println("Email : " + message);
    }
}