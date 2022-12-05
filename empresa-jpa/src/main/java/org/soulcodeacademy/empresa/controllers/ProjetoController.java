package org.soulcodeacademy.empresa.controllers;


import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.ProjetoDTO;
import org.soulcodeacademy.empresa.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController // Retorno de dados
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;


    @GetMapping("/projetos")
    public List<Projeto> listar() {
        return this.projetoService.listar();
    }


    @GetMapping("/projetos/{idProjeto}")
    public Projeto getProjeto(@PathVariable Integer idProjeto) {
        return this.projetoService.getProjeto(idProjeto);
    }

    //salvar
    @PostMapping("/projetos")
    public Projeto salvar(@Valid @RequestBody ProjetoDTO projeto) {
        Projeto salvo = this.projetoService.salvar(projeto);
        return salvo;
    }

    //atualizar
    @PutMapping("/projetos/{idProjeto}")
    public Projeto atualizar(@PathVariable Integer idProjeto, @Valid @RequestBody ProjetoDTO projeto) {
        Projeto atualizado = this.projetoService.atualizar(idProjeto, projeto);
        return atualizado;
    }

    //deletar
    @DeleteMapping("/projetos/{idProjeto}")
    public void deletar(@PathVariable Integer idProjeto) {
        this.projetoService.deletar(idProjeto);
    }




}