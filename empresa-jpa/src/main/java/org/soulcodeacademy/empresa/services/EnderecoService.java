package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Listar todos
    public List<Endereco> listar(){

        return this.enderecoRepository.findAll();
    }

    // Listar por ID
    public Endereco getEndereco(Integer idEndereco){
        Optional<Endereco> endereco = this.enderecoRepository.findById(idEndereco);

        if(endereco.isEmpty()){
            throw new RuntimeException("Endereço não encontrado.");
        } else {
            return endereco.get();
        }
    }

    public Endereco salvar(EnderecoDTO dto) {
        // INSERT INTO cargo
        Endereco endereco = new Endereco(null, dto.getCidade(), dto.getUf());
        Endereco enderecoSalvo = this.enderecoRepository.save(endereco);
        return enderecoSalvo;
    }

    // Atualizar
    // Precisa do ID do cargo e dos dados atualizados
    public Endereco atualizar(Integer idEndereco, EnderecoDTO dto) {
        // Verificar se o cargo existe mesmo
        Endereco enderecoAtual = this.getEndereco(idEndereco);

        enderecoAtual.setCidade(dto.getCidade());
        enderecoAtual.setUf(dto.getUf());

        // Atualiza a entidade pois ela possui um ID diferente de nulo
        Endereco atualizado = this.enderecoRepository.save(enderecoAtual);
        return atualizado;
    }

    // Deletar
    public void deletar(Integer idEndereco) {
        Endereco endereco= this.getEndereco(idEndereco);
        // DELETE FROM cargo WHERE idCargo = ?
        this.enderecoRepository.delete(endereco);
    }
}