package com.github.cliente.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public record Cliente(
        @Id String id,
        String nome,
        String dtNascimento,
        Endereco endereco
) {}
