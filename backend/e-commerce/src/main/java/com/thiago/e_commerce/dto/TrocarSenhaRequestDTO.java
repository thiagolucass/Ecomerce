package com.thiago.e_commerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrocarSenhaRequestDTO {
    private String senhaAtual;
    private String senhaNova;
}