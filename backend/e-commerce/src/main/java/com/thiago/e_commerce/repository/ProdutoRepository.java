package com.thiago.e_commerce.repository;

import com.thiago.e_commerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
