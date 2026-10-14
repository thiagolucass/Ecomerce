package com.thiago.e_commerce.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "produtos")
public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<PedidoProduto> pedidoProdutos;

    @NotBlank(message = "Nome do produto é obrigatório")
    private String nome;

    @Positive(message = "Preço tem que ser maior que 0")
    private BigDecimal preco;

    @PositiveOrZero(message = "Estoque não pode ser negativo")
    private Long estoque;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

}