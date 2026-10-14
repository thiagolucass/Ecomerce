package com.thiago.e_commerce.service;

import com.thiago.e_commerce.exception.RecursoNaoEncontradoException;
import com.thiago.e_commerce.model.Produto;
import com.thiago.e_commerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;



    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }
    public Produto buscarPorId(UUID id){
        return produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));
    }
    public Produto salvar(Produto produto){

        return produtoRepository.save(produto);
    }
    public Produto atualizar(UUID id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setEstoque(produtoAtualizado.getEstoque());
        produto.setDescricao(produtoAtualizado.getDescricao());

        return produtoRepository.save(produto);
    }

    public Produto atualizarParcial(UUID id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        if (produtoAtualizado.getNome() != null) {
            produto.setNome(produtoAtualizado.getNome());
        }
        if (produtoAtualizado.getPreco() != null) {
            produto.setPreco(produtoAtualizado.getPreco());
        }
        if (produtoAtualizado.getEstoque() != null) {
            produto.setEstoque(produtoAtualizado.getEstoque());
        }
        if (produtoAtualizado.getDescricao() != null) {
            produto.setDescricao(produtoAtualizado.getDescricao());
        }

        return produtoRepository.save(produto);
    }
    public void deletar(UUID id){
        produtoRepository.deleteById(id);
    }
}
