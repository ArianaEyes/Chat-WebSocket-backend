package com.chat.ariana.services;

import com.chat.ariana.Model.Mensaje;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatService {

    private final UsuarioService usuarioService;

    public ChatService(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    public Mensaje procesarMensaje(Mensaje mensaje){
        mensaje.setFecha(LocalDateTime.now());

        boolean existe = usuarioService
                        .obtenerUsuarios()
                        .stream()
                        .anyMatch(usuario -> usuario.getId_usuario().equals(mensaje.getId_usuario()));

        if(!existe){
            throw new RuntimeException("El usuario no existe");
        }


        // guardar mediante api php
        return mensaje;
    }
}
