package com.github.Clientee.controller;

import com.github.Clientee.dto.clienteRequest;
import com.github.Clientee.dto.clienteResponse;
import com.github.Clientee.model.Endereco;
import com.github.Clientee.model.cliente;
import com.github.Clientee.service.clienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class clienteController {

    private final clienteService service;

    public clienteController(clienteService service) {
        this.service = service;
    }

    @PostMapping
    public clienteResponse criar(@RequestBody clienteRequest request) {

        Endereco endereco = new Endereco(
                request.getLogradouro(),
                request.getNumero(),
                request.getCidade(),
                request.getEstado()
        );

        cliente cliente = new cliente(
                null,
                request.getNome(),
                request.getDtNascimento(),
                endereco
        );

        cliente salvo = service.criar(cliente);
        return converterParaResponse(salvo);
    }

    @GetMapping
    public List<clienteResponse> listar() {
        return service.listar()
                .stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public clienteResponse buscarPorId(@PathVariable String id) {
        cliente cliente = service.buscarPorId(id);
        return converterParaResponse(cliente);
    }

    @PutMapping("/{id}")
    public clienteResponse atualizar(@PathVariable String id, @RequestBody clienteRequest request) {

        Endereco endereco = new Endereco(
                request.getLogradouro(),
                request.getNumero(),
                request.getCidade(),
                request.getEstado()
        );

        cliente cliente = new cliente(
                null,
                request.getNome(),
                request.getDtNascimento(),
                endereco
        );

        cliente atualizado = service.atualizar(id, cliente);
        return converterParaResponse(atualizado);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {
        return service.deletar(id);
    }

    private clienteResponse converterParaResponse(cliente cliente) {
        Endereco endereco = cliente.endereco();

        return new clienteResponse(
                cliente.id(),
                cliente.nome(),
                cliente.dtNascimento(),
                endereco != null ? endereco.logradouro() : null,
                endereco != null ? endereco.numero() : null,
                endereco != null ? endereco.cidade() : null,
                endereco != null ? endereco.estado() : null
        );
    }
}