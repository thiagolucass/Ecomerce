package com.thiago.e_commerce.dto;


import com.thiago.e_commerce.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ClienteResponseDTO {

    private UUID id;
    private String nome;
    private String email;
    private String numero;
    private List<EnderecoResponseDTO> enderecos;

    public ClienteResponseDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.numero = cliente.getNumero();
        this.enderecos = cliente.getEderecos()
                .stream()
                .map(endereco -> new EnderecoResponseDTO(endereco))
                .toList();
    }
}
