package com.thiago.e_commerce.controller;

import com.thiago.e_commerce.dto.ClienteResponseDTO;
import com.thiago.e_commerce.dto.TrocarSenhaRequestDTO;
import com.thiago.e_commerce.model.Cliente;

import com.thiago.e_commerce.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteResponseDTO> listarTodos(){
        return clienteService.listarTodos()
                .stream()
                .map(cliente -> new ClienteResponseDTO(cliente))
                .toList();
    }
    @GetMapping("/{id}")
    public ClienteResponseDTO bucasrPorId(@PathVariable UUID id){
        return new ClienteResponseDTO(clienteService.buscarPorId(id));
    }
    @PostMapping
    public ClienteResponseDTO salvar(@Valid  @RequestBody Cliente cliente){
        return new ClienteResponseDTO(clienteService.salvar(cliente));
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(@PathVariable UUID id, @Valid @RequestBody Cliente cliente) {
        return new ClienteResponseDTO(clienteService.atualizar(id, cliente));
    }

    @PatchMapping("/{id}")
    public ClienteResponseDTO atualizarParcial(@PathVariable UUID id,@RequestBody Cliente cliente ){
        return new ClienteResponseDTO(clienteService.atualizarParcial(id,cliente));
    }
    @PatchMapping("/{id}/senha")
    public ClienteResponseDTO trocarSenha(@PathVariable UUID id, @RequestBody TrocarSenhaRequestDTO trocarSenhaRequestDTO) {
        return new ClienteResponseDTO(clienteService.trocarSenha(id, trocarSenhaRequestDTO));
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        clienteService.deletar(id);
    }
}