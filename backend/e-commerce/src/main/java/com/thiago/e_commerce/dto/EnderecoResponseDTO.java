package com.thiago.e_commerce.dto;

import com.thiago.e_commerce.model.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EnderecoResponseDTO {
    private UUID id;
    private String apelido;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoResponseDTO(Endereco endereco){
        this.id = endereco.getId();
        this.apelido = endereco.getApelido();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.cep = endereco.getCep();
    }
}
