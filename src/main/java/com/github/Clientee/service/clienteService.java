package com.github.Clientee.service;

import com.github.Clientee.model.cliente;
import com.github.Clientee.repository.clienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clienteService {

    private final clienteRepository repository;

    public clienteService(clienteRepository repository) {
        this.repository = repository;
    }

    public cliente criar(cliente cliente) {
        return repository.save(cliente);
    }

    public List<cliente> listar() {
        return repository.findAll();
    }

    public cliente buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public cliente atualizar(String id, cliente novoCliente) {
        cliente existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente atualizado = new cliente(
                existente.id(),
                novoCliente.nome(),
                novoCliente.dtNascimento(),
                novoCliente.endereco()
        );

        return repository.save(atualizado);
    }

    public String deletar(String id) {
        repository.deleteById(id);
        return "Cliente deletado com sucesso";
    }
}