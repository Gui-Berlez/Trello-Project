package com.project.trello_integration.controller;

import com.project.trello_integration.dto.CardRequest;
import com.project.trello_integration.service.TrelloService;
import org.springframework.web.bind.annotation.*;

@RestController //  diz ao Spring que essa classe responde requisições HTTP
@RequestMapping("/trello") //  define que todos os endpoints dessa classe começam com /trello
public class TrelloController {

    private final TrelloService trelloService;

    public TrelloController(TrelloService trelloService) {
        this.trelloService = trelloService;
    }

    @PostMapping("/card") // cria um endpoint POST /trello/card
    public String criarCard(@RequestBody CardRequest request) { //@RequestBody — converte automaticamente o JSON que chegar para um objeto CardRequest
        return trelloService.criarCard(request);
    }
}