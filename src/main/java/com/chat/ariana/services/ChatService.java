package com.chat.ariana.services;

import com.chat.ariana.Model.Grupo;
import com.chat.ariana.Model.Mensaje;
import com.chat.ariana.Model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatService {

    private final UsuarioService usuarioService;
    private final MensajesService mensajesService;
    private final GrupoService grupoService;

    public ChatService(UsuarioService usuarioService,
                       MensajesService mensajesService,
                       GrupoService grupoService){
        this.usuarioService = usuarioService;
        this.mensajesService = mensajesService;
        this.grupoService = grupoService;
    }
    public Mensaje procesarMensaje(Mensaje mensaje){


        mensaje.setFecha(LocalDateTime.now());

        try {
            Grupo grupo = grupoService.obtenerGrupoPorId(mensaje.getId_grupo());
            Usuario usuario = usuarioService.obtenerUsuarioPorId(mensaje.getId_usuario());
        } catch (Exception e) {
            throw new RuntimeException("Usuario no existe");
        }




        // guardar mediante api php
        return mensajesService.agregarMensaje(mensaje);
    }
}
