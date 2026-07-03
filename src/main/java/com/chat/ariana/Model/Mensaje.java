package com.chat.ariana.Model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {
    Integer id_mensaje;
    Integer id_grupo;
    Integer id_usuario;
    String contenido;
    LocalDateTime fecha;
}
