package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {
    @Autowired
    private EmpregadoRepository empregadoRepository;

    // Listar todos
    public List<Empregado> listar(){

        return this.empregadoRepository.findAll();
    }

    // Listar por ID
    public Empregado getEmpregado(Integer idEmpregado){

        Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);
        if(empregado.isEmpty()){
            throw new RuntimeException("O Empregado não foi encontrado!");
        }
        else{
            return empregado.get();
        }
    }

    @Autowired
    private EnderecoService enderecoService;
    public Empregado criarEmpregado(EmpregadoDTO dto){

        Endereco enderecoDoEmpregado = this.enderecoService.getEndereco(dto.getIdEndereco());
        Empregado novoEmpregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());
        novoEmpregado.setEndereco(enderecoDoEmpregado);
        Empregado empregadoValido = this.empregadoRepository.save(novoEmpregado);
        return empregadoValido;
    }

    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto){
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);
        Endereco enderecoEmpregado = this.enderecoService.getEndereco(dto.getIdEndereco());
        empregadoAtual.setNome(dto.getNome());
        empregadoAtual.setEmail(dto.getEmail());
        empregadoAtual.setSalario(dto.getSalario());
        empregadoAtual.setEndereco(enderecoEmpregado);

        Empregado atualizado = this.empregadoRepository.save(empregadoAtual);
        return atualizado;

    }

    public void deletar(Integer idEmpregado){
        Empregado empregado = this.getEmpregado(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }

}