package com.thiago.e_commerce.service;

import com.thiago.e_commerce.dto.PedidoProdutoRequestDTO;
import com.thiago.e_commerce.exception.EstoqueInsuficienteException;
import com.thiago.e_commerce.exception.RecursoNaoEncontradoException;
import com.thiago.e_commerce.model.Pedido;
import com.thiago.e_commerce.model.PedidoProduto;
import com.thiago.e_commerce.model.Produto;
import com.thiago.e_commerce.repository.PedidoProdutoRepository;
import com.thiago.e_commerce.repository.PedidoRepository;
import com.thiago.e_commerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoProdutoService {

    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    private void baixarEstoque(PedidoProduto pedidoProduto, Produto produto){
        if(produto.getEstoque() < pedidoProduto.getQuantidade()){
           throw new EstoqueInsuficienteException("Estoque insuficiente");
        }
        Long produtoEstoque = produto.getEstoque() - pedidoProduto.getQuantidade();
        produto.setEstoque(produtoEstoque);
        produtoRepository.save(produto);
    }
    private void calcularSubTotal(PedidoProduto pedidoProduto, Produto produto){
        BigDecimal precoProduto = produto.getPreco();
        BigDecimal subTotal = precoProduto.multiply(BigDecimal.valueOf(pedidoProduto.getQuantidade()));
        pedidoProduto.setSubTotal(subTotal);
    }

    public List<PedidoProduto> listarTodos(){
        return pedidoProdutoRepository.findAll();
    }

    public PedidoProduto buscarPorId(UUID id){
        return pedidoProdutoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Pedido e produto não encontrado"));
    }
    public PedidoProduto salvar(PedidoProdutoRequestDTO pedidoProdutoRequestDTO){
        Pedido pedido = pedidoRepository.findById(pedidoProdutoRequestDTO.getPedidoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pedido não encontrado"));
        Produto produto = produtoRepository.findById(pedidoProdutoRequestDTO.getProdutoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setPedido(pedido);
        pedidoProduto.setProduto(produto);
        pedidoProduto.setPrecoUnitario(produto.getPreco());
        pedidoProduto.setQuantidade(pedidoProdutoRequestDTO.getQuantidade());

        calcularSubTotal(pedidoProduto, produto);
        baixarEstoque(pedidoProduto, produto);


        return pedidoProdutoRepository.save(pedidoProduto);



    }
    public void deletar(UUID id){
        pedidoProdutoRepository.deleteById(id);
    }
}
