package com.thiago.e_commerce.controller;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.thiago.e_commerce.auth.JwtService;
import com.thiago.e_commerce.dto.PedidoProdutoResponseDTO;
import com.thiago.e_commerce.dto.PedidoResponseDTO;
import com.thiago.e_commerce.model.Pedido;
import com.thiago.e_commerce.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoResponseDTO> listarTodos() {
        return
                pedidoService.listarTodos()
                        .stream()
                        .map(pedido -> new PedidoResponseDTO(pedido))
                        .toList();
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO buscarPorId(@PathVariable UUID id) {
        return
                new PedidoResponseDTO(pedidoService.buscarPorId(id));
    }

    @PostMapping
    public PedidoResponseDTO salvar(@Valid  @RequestBody Pedido pedido) {

        return new PedidoResponseDTO(pedidoService.salvar(pedido));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        pedidoService.deletar(id);
    }
}