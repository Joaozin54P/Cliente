package com.github.Clientee.model;


public record Endereco(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}