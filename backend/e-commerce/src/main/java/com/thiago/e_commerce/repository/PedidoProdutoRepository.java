package com.thiago.e_commerce.repository;

import com.thiago.e_commerce.model.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, UUID> {
}
