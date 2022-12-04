package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    // Listar dependentes (GET) →   /dependentes
    @GetMapping("/dependentes")
    public List<Dependente> listar() {
        // SELECT * FROM dependente
        return this.dependenteService.listar();
    }

    // Listar por ID (GET) →    /dependentes/{id}
    @GetMapping("/dependentes/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente){
        return this.dependenteService.getDependente(idDependente);
    }

    // Salvar novo dependente (POST)
    @PostMapping("/dependentes")
    public Dependente salvar(@Valid @RequestBody DependenteDTO dto) {
        Dependente dependente = this.dependenteService.salvar(dto);
        return dependente;
    }

    // Atualizar dependente (PUT)
    @PutMapping("/dependentes/{idDependente}")
    public Dependente atualizar(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dto) {
        Dependente atualizado = this.dependenteService.atualizar(idDependente, dto);
        return atualizado;
    }

    // Deletar dependente (DELETE)
    @DeleteMapping("/dependentes/{idDependente}")
    public void deletar(@PathVariable Integer idDependente) {
        this.dependenteService.deletar(idDependente);
    }

}
