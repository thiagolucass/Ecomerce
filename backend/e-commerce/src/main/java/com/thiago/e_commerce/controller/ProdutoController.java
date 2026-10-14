package com.thiago.e_commerce.controller;

import com.thiago.e_commerce.dto.ProdutoResponseDTO;
import com.thiago.e_commerce.model.Produto;
import com.thiago.e_commerce.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtosService;

    @GetMapping
    public List<ProdutoResponseDTO> listarTodos() {
        return produtosService.listarTodos()
                        .stream()
                        .map(produto -> new ProdutoResponseDTO(produto))
                        .toList();
    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO buscarPorId(@PathVariable UUID id) {
        return
                new ProdutoResponseDTO(produtosService.buscarPorId(id));
    }

    @PostMapping
    public ProdutoResponseDTO salvar(@Valid  @RequestBody Produto produto) {
        return new ProdutoResponseDTO(produtosService.salvar(produto));
    }

    @PutMapping("/{id}")
    public ProdutoResponseDTO atualizar(@PathVariable UUID id, @Valid @RequestBody Produto produto) {
        return new ProdutoResponseDTO(produtosService.atualizar(id, produto));
    }

    @PatchMapping("/{id}")
    public ProdutoResponseDTO atualizarParcial(@PathVariable UUID id, @RequestBody Produto produto) {
        return new ProdutoResponseDTO(produtosService.atualizarParcial(id, produto));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        produtosService.deletar(id);
    }
}