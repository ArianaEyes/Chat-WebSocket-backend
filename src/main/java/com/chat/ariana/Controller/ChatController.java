package com.chat.ariana.Controller;

import com.chat.ariana.Model.Mensaje;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Mensaje recibirMensaje(Mensaje mensaje) {

        mensaje.setFecha(LocalDateTime.now());
        System.out.println("RECIBIDO: " + mensaje);
        return mensaje;
    }

}
