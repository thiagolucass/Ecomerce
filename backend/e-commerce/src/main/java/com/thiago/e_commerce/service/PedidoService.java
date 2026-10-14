package com.thiago.e_commerce.service;

import com.thiago.e_commerce.exception.RecursoNaoEncontradoException;
import com.thiago.e_commerce.model.Pedido;
import com.thiago.e_commerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos(){
        return pedidoRepository.findAll();
    }
    public Pedido buscarPorId(UUID id){
        return pedidoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado"));
    }
    public Pedido salvar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public void deletar(UUID id){
        pedidoRepository.deleteById(id);
    }
}
