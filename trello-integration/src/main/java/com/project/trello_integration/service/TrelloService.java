package com.project.trello_integration.service;

import com.project.trello_integration.dto.CardRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.HashMap;
import java.util.Map;

@Service //  avisa o Spring que essa classe contém lógica de negócio
public class TrelloService {

    private final String API_KEY = "SUA_API_KEY";
    private final String TOKEN   = "SEU_TOKEN";

    public String criarCard(CardRequest request) {
        String url = "https://api.trello.com/1/cards";

        RestTemplate restTemplate = new RestTemplate(); // O cliente HTTP do Spring, que faz a chamada para a API do Trello

        // Montamos um Map com os parâmetros que a API do Trello espera e enviamos via POST
        Map<String, String> params = new HashMap<>();
        params.put("key",    API_KEY);
        params.put("token",  TOKEN);
        params.put("idList", request.getIdLista());
        params.put("name",   request.getTitulo());
        params.put("desc",   request.getDescricao());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class
        );

        return response.getBody();
    }
}