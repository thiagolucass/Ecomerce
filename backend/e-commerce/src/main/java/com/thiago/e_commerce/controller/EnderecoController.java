package com.thiago.e_commerce.controller;

import com.thiago.e_commerce.dto.EnderecoResponseDTO;
import com.thiago.e_commerce.model.Endereco;
import com.thiago.e_commerce.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoResponseDTO> listarTodos(){
        return enderecoService.listarTodos()
                .stream()
                .map(endereco -> new EnderecoResponseDTO(endereco))
                .toList();
    }

    @GetMapping("/{id}")
    public EnderecoResponseDTO buscarPorId(@PathVariable UUID id){
        return new EnderecoResponseDTO(enderecoService.buscarPorId(id));
    }

    @PostMapping
    public EnderecoResponseDTO salvar(@Valid @RequestBody Endereco endereco){
        return new EnderecoResponseDTO(enderecoService.salvar(endereco));
    }
    @PutMapping("/{id}")
    public EnderecoResponseDTO atualizar(@PathVariable UUID id, @Valid @RequestBody Endereco endereco) {
        return new EnderecoResponseDTO(enderecoService.atualizar(id, endereco));
    }

    @PatchMapping("/{id}")
    public EnderecoResponseDTO atualizarParcial(@PathVariable UUID id, @RequestBody Endereco endereco) {
        return new EnderecoResponseDTO(enderecoService.atualizarParcial(id, endereco));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id){
        enderecoService.deletar(id);
    }
}