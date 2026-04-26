package com.github.cliente.model;

public record Endereco(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}
