package com.github.cliente.controller;

import com.github.cliente.dto.ClienteRequest;
import com.github.cliente.dto.ClienteResponse;
import com.github.cliente.model.Cliente;
import com.github.cliente.model.Endereco;
import com.github.cliente.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ClienteResponse criar(@RequestBody ClienteRequest request) {
        Cliente cliente = converterParaCliente(request);
        Cliente salvo = service.criar(cliente);
        return converterParaResponse(salvo);
    }

    @GetMapping
    public List<ClienteResponse> listar() {
        return service.listar()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ClienteResponse buscarPorId(@PathVariable String id) {
        Cliente cliente = service.buscarPorId(id);
        return converterParaResponse(cliente);
    }

    @PutMapping("/{id}")
    public ClienteResponse atualizar(@PathVariable String id, @RequestBody ClienteRequest request) {
        Cliente cliente = converterParaCliente(request);
        Cliente atualizado = service.atualizar(id, cliente);
        return converterParaResponse(atualizado);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {
        return service.deletar(id);
    }

    private Cliente converterParaCliente(ClienteRequest request) {
        Endereco endereco = new Endereco(
                request.getLogradouro(),
                request.getNumero(),
                request.getCidade(),
                request.getEstado()
        );

        return new Cliente(
                null,
                request.getNome(),
                request.getDtNascimento(),
                endereco
        );
    }

    private ClienteResponse converterParaResponse(Cliente cliente) {
        Endereco endereco = cliente.endereco();

        return new ClienteResponse(
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
