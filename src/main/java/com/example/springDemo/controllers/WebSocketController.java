//package com.example.springDemo.controllers;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class WebSocketController {
//
//    @MessageMapping("/login")
//    @SendTo("/topic/admin")
//    public Message handleLogin(Message message) {
//        return message;
//    }
//
//    @MessageMapping("/admin")
//    @SendTo("/topic/user")
//    public Message handleAdmin(Message message) {
//        return message;
//    }
//
//    public static class Message {
//        private String from;
//        private String content;
//
//        public String getFrom() {
//            return from;
//        }
//
//        public void setFrom(String from) {
//            this.from = from;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//    }
//}

package com.example.springDemo.controllers;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/login")
    @SendTo("/topic/admin")
    public Message handleLogin(LoginMessage loginMessage) {
        String email = loginMessage.getEmail();
        String password = loginMessage.getPassword();

        Message response = new Message();
        response.setFrom(loginMessage.getFrom());

        if (email == null || email.isEmpty()) {
            response.setContent("Error: Email is missing.");
        } else if (password == null || password.isEmpty()) {
            response.setContent("Error: Password is missing.");
        } else {
            response.setContent("Login successful.");
        }
        return response;
    }

    @MessageMapping("/admin")
    @SendTo("/topic/user")
    public Message handleAdmin(Message message) {
        return message;
    }
//    @MessageMapping("/admin")
//    @SendTo("/message/login")
//    public Message handleAdmin1(Message message1){
//        return message1;
//    }

    public static class LoginMessage {
        private String from;
        private String email;
        private String password;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class Message {
        private String from;
        private String content;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
