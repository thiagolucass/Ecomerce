package com.thiago.e_commerce.controller;

import com.thiago.e_commerce.dto.PedidoProdutoRequestDTO;
import com.thiago.e_commerce.dto.PedidoProdutoResponseDTO;
import com.thiago.e_commerce.service.PedidoProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedido_produtos")
public class PedidoProdutoController {

    @Autowired
    private PedidoProdutoService pedidoProdutoService;

    @GetMapping
    public List<PedidoProdutoResponseDTO> listarTodos() {
        return pedidoProdutoService.listarTodos()
                .stream()
                .map(pedidoProduto -> new PedidoProdutoResponseDTO(pedidoProduto))
                .toList();
    }

    @GetMapping("/{id}")
    public PedidoProdutoResponseDTO buscarPorId(@PathVariable UUID id) {
        return new PedidoProdutoResponseDTO(pedidoProdutoService.buscarPorId(id));
    }

    @PostMapping
    public PedidoProdutoResponseDTO salvar(@Valid  @RequestBody PedidoProdutoRequestDTO pedidoProdutoRequestDTO) {
        return new PedidoProdutoResponseDTO(pedidoProdutoService.salvar(pedidoProdutoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        pedidoProdutoService.deletar(id);
    }
}