package com.github.Clientee.repository;

import com.github.Clientee.model.cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface clienteRepository extends MongoRepository<cliente, String> {
}