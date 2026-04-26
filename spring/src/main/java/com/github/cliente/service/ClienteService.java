package com.github.cliente.service;

import com.github.cliente.model.Cliente;
import com.github.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(String id, Cliente novoCliente) {
        Cliente existente = buscarPorId(id);

        Cliente atualizado = new Cliente(
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
