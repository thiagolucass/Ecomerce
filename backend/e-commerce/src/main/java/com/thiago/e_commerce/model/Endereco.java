package com.thiago.e_commerce.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @NotNull(message = "Cliente é obrigatório")
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private String apelido;
    @NotBlank(message = "A rua é obrigatória")
    private String rua;

    @NotBlank(message = "O número é obrigatório")
    private String numero;

    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    private String estado;

    @NotBlank(message = "O CEP é obrigatório")
    private String cep;
}