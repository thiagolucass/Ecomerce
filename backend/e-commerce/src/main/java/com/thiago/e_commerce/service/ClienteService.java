package com.thiago.e_commerce.service;

import com.thiago.e_commerce.dto.TrocarSenhaRequestDTO;
import com.thiago.e_commerce.exception.RecursoNaoEncontradoException;
import com.thiago.e_commerce.model.Cliente;
import com.thiago.e_commerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }
    public Cliente buscarPorId(UUID id) {
        return clienteRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Cliente não encontrado"));
    }
    public Cliente salvar(Cliente cliente){
        String senhaCriptografada = passwordEncoder.encode(cliente.getSenha());
        cliente.setSenha(senhaCriptografada);
        return clienteRepository.save(cliente);
    }
    public Cliente atualizar(UUID id, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setNumero(clienteAtualizado.getNumero());

        return clienteRepository.save(cliente);
    }
    public Cliente atualizarParcial(UUID id, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));


        if (clienteAtualizado.getNome() != null){
            cliente.setNome(clienteAtualizado.getNome());
        }
        if (clienteAtualizado.getEmail() != null){
            cliente.setEmail(clienteAtualizado.getEmail());
        }
        if (clienteAtualizado.getNumero() != null){
            cliente.setNumero(clienteAtualizado.getNumero());
        }


        return clienteRepository.save(cliente);
    }
    public Cliente trocarSenha(UUID id, TrocarSenhaRequestDTO trocarSenhaRequestDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        if (!passwordEncoder.matches(trocarSenhaRequestDTO.getSenhaAtual(), cliente.getSenha())) {
            throw new RuntimeException("Senha atual incorreta");
        }

        cliente.setSenha(passwordEncoder.encode(trocarSenhaRequestDTO.getSenhaNova()));

        return clienteRepository.save(cliente);
    }

        public void deletar (UUID id){
            clienteRepository.deleteById(id);
        }

    }