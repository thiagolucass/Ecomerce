package com.thiago.e_commerce.controller;

import com.thiago.e_commerce.auth.ClienteUserDetailsService;
import com.thiago.e_commerce.auth.JwtService;
import com.thiago.e_commerce.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ClienteUserDetailsService clienteUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO loginRequestDTO) {
        UserDetails userDetails = clienteUserDetailsService.loadUserByUsername(loginRequestDTO.getEmail());

        if (!passwordEncoder.matches(loginRequestDTO.getSenha(), userDetails.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.gerarToken(loginRequestDTO.getEmail());
    }
}