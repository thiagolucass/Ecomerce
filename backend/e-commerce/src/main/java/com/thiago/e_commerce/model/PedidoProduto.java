package com.thiago.e_commerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "pedido_produtos")
public class PedidoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne
    @NotNull(message = "Pedido é obrigatório")
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @NotNull(message = "Produto é obrigatório")
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Positive(message = "A quantidade tem que ser maior que 0")
    private Long quantidade;

    @Positive(message = "O preço unitário tem que ser maior que 0")
    private BigDecimal precoUnitario;

    @Positive(message = "O preço unitário tem que ser maior que 0")
    private BigDecimal subTotal;
}
