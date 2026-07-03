package com.chat.ariana.services;

import com.chat.ariana.Model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;

@Service
public class UsuarioService {
        private final RestClient restClient;

        public UsuarioService(RestClient.Builder builder){
            this.restClient = builder.build();
        }

        public List<Usuario> obtenerUsuarios(){
            return restClient
                    .get()
                    .uri("https://arianini.alwaysdata.net/usuarios_chat.php")
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<Usuario>>() {});
        }


}
