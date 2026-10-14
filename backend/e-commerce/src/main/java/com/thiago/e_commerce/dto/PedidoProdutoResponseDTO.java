package com.thiago.e_commerce.dto;

import com.thiago.e_commerce.model.PedidoProduto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class PedidoProdutoResponseDTO {

    private UUID id;
    private PedidoResponseDTO pedido;
    private ProdutoResponseDTO produto;
    private Long quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subTotal;

    public PedidoProdutoResponseDTO (PedidoProduto pedidoProduto){

        this.id = pedidoProduto.getId();
        this.pedido = new PedidoResponseDTO(pedidoProduto.getPedido());
        this.produto = new ProdutoResponseDTO(pedidoProduto.getProduto());
        this.quantidade = pedidoProduto.getQuantidade();
        this.precoUnitario = pedidoProduto.getPrecoUnitario();
        this.subTotal = pedidoProduto.getSubTotal();

    }
}
