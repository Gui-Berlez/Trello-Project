package com.project.trello_integration.dto;
import lombok.Data;

@Data
public class CardRequest {
    private String titulo;
    private String descricao;
    private String idLista;

}
