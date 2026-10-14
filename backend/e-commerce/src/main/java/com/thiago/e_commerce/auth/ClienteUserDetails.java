package com.thiago.e_commerce.auth;

import com.thiago.e_commerce.model.Cliente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ClienteUserDetails implements UserDetails {

    private final Cliente cliente;

    public ClienteUserDetails(Cliente cliente){
        this.cliente = cliente;
    }
    public Cliente getCliente() {
        return cliente;
    }
    @Override
    public String getPassword(){
        return cliente.getSenha();
    }
    @Override
    public String getUsername() {
        return cliente.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}