package com.thiago.e_commerce.dto;

import com.thiago.e_commerce.model.Pedido;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PedidoResponseDTO {
    private UUID id;
    private UUID clienteId;
    private String clienteNome;
    private LocalDate data;

    public PedidoResponseDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.clienteId = pedido.getCliente().getId();
        this.clienteNome = pedido.getCliente().getNome();
        this.data = pedido.getData();
    }
}