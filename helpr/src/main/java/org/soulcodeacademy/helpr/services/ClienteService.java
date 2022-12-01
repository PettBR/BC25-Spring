package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Para tornar o objeto da classe injetável
public class ClienteService {

    @Autowired // injeção
    private ClienteRepository clienteRepository;

    // Listar todos os clientes (GET)
    public List<Cliente> listar() {
        return this.clienteRepository.findAll();
    }

    // Listar um cliente pelo ID (GET)
    public Cliente getCliente(Integer idCliente) {
        Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);

        if(cliente.isEmpty()) {
            throw new RecursoNaoEncontradoError("O cliente especificado não foi encontrado.");
        } else {
            return cliente.get();
        }
    }

    public Cliente salvar(ClienteDTO dto) {
        // Criação da entidade Cliente, a partir dos dados validados do DTO
        Cliente novoCliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getTelefone());
        return this.clienteRepository.save(novoCliente);
    }

    // Atualizar (PUT)
    public Cliente atualizar(Integer idCliente, ClienteDTO dto) {
        // Busca pelo cliente com o idCliente
        Cliente clienteAtual = this.getCliente(idCliente);
        // Busca dos dados da requisição para fazer a mudança no repository
        clienteAtual.setNome(dto.getNome());
        clienteAtual.setEmail(dto.getEmail());
        clienteAtual.setCpf(dto.getCpf());
        clienteAtual.setSenha(dto.getSenha());
        clienteAtual.setTelefone(dto.getTelefone());

        Cliente atualizado = this.clienteRepository.save(clienteAtual);
        return atualizado;
    }

    public void deletar(Integer idCliente) {
        Cliente cliente = this.getCliente(idCliente);
        this.clienteRepository.delete(cliente);
    }

}

// Quando usar entidade e dto?
// Entidade = retorno dos dados
// DTO = entrada de dados