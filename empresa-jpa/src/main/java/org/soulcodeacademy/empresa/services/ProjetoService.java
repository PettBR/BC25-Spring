package org.soulcodeacademy.empresa.services;


import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private EmpregadoService empregadoService;


    // Listar todos
    public List<Projeto> listar() {
        return this.projetoRepository.findAll();
    }


    // Listar pelo ID
    public Projeto getProjeto(Integer idProjeto) {
        Optional<Projeto> projeto = this.projetoRepository.findById(idProjeto);


        if (projeto.isEmpty()) {
            throw new RuntimeException("O projeto não foi encontrado!"); // Erro
        } else {
            return projeto.get();
        }
    }


    //salvar
    public Projeto salvar(ProjetoDTO dto) {
        Projeto projeto = new Projeto(null, dto.getNome(), dto.getOrcamento(), dto.getDescricao());
        Projeto projetoSalvo = this.projetoRepository.save(projeto);
        return projetoSalvo;
    }


    //atualizar
    public Projeto atualizar(Integer idProjeto, ProjetoDTO dto) {
        Projeto projetoAtual = this.getProjeto(idProjeto);

        projetoAtual.setNome(dto.getNome());
        projetoAtual.setDescricao(dto.getDescricao());
        projetoAtual.setOrcamento(dto.getOrcamento());

        Projeto atualizado = this.projetoRepository.save(projetoAtual);
        return atualizado;
    }


    //deletar
    public void deletar(Integer idProjeto) {
        Projeto projeto = this.getProjeto(idProjeto);
        this.projetoRepository.delete(projeto);
    }

}