package com.thiago.e_commerce.dto;
import com.thiago.e_commerce.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
public class ProdutoResponseDTO {
    private UUID id;
    private String nome;
    private BigDecimal preco;
    private Long estoque;
    private String descricao;

    public ProdutoResponseDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
        this.descricao = produto.getDescricao();
    }
}
