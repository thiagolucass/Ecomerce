package com.thiago.e_commerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PedidoProdutoRequestDTO {
    private UUID pedidoId;
    private UUID produtoId;
    private Long quantidade;
}