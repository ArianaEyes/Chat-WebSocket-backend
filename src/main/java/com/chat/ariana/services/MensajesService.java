package com.chat.ariana.services;

import com.chat.ariana.Model.Mensaje;
import com.chat.ariana.Model.Usuario;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class MensajesService {
    private final RestClient restClient;

    public MensajesService(RestClient.Builder builder){
        this.restClient = builder.build();
    }

    public List<Mensaje> obtenerMensajes(){
        return restClient
                .get()
                .uri("https://arianini.alwaysdata.net/mensajes.php")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Mensaje>>() {});
    }
}
