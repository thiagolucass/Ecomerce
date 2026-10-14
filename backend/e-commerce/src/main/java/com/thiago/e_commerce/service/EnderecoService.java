package com.thiago.e_commerce.service;

import com.thiago.e_commerce.exception.RecursoNaoEncontradoException;
import com.thiago.e_commerce.model.Endereco;
import com.thiago.e_commerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos(){
        return enderecoRepository.findAll();
    }

    public Endereco buscarPorId(UUID id){
        return enderecoRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Endereço não encontrado"));
    }

    public Endereco salvar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizar(UUID id, Endereco enderecoAtualizado) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Endereço não encontrado"));

        endereco.setApelido(enderecoAtualizado.getApelido());
        endereco.setRua(enderecoAtualizado.getRua());
        endereco.setNumero(enderecoAtualizado.getNumero());
        endereco.setBairro(enderecoAtualizado.getBairro());
        endereco.setCidade(enderecoAtualizado.getCidade());
        endereco.setEstado(enderecoAtualizado.getEstado());
        endereco.setCep(enderecoAtualizado.getCep());

        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarParcial(UUID id, Endereco enderecoAtualizado) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Endereço não encontrado"));

        if (enderecoAtualizado.getApelido() != null) endereco.setApelido(enderecoAtualizado.getApelido());
        if (enderecoAtualizado.getRua() != null) endereco.setRua(enderecoAtualizado.getRua());
        if (enderecoAtualizado.getNumero() != null) endereco.setNumero(enderecoAtualizado.getNumero());
        if (enderecoAtualizado.getBairro() != null) endereco.setBairro(enderecoAtualizado.getBairro());
        if (enderecoAtualizado.getCidade() != null) endereco.setCidade(enderecoAtualizado.getCidade());
        if (enderecoAtualizado.getEstado() != null) endereco.setEstado(enderecoAtualizado.getEstado());
        if (enderecoAtualizado.getCep() != null) endereco.setCep(enderecoAtualizado.getCep());

        return enderecoRepository.save(endereco);
    }

    public void deletar(UUID id){
        enderecoRepository.deleteById(id);
    }
}