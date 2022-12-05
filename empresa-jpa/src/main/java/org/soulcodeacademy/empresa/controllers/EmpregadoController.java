package org.soulcodeacademy.empresa.controllers;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {
    @Autowired
    public EmpregadoService empregadoService;

    // Listar todos
    @GetMapping("/empregados")
    public List<Empregado> lista(){
        return this.empregadoService.listar();
    }

    //Listar por ID
    @GetMapping("/empregados/{id}")
    public Empregado getempregado(@PathVariable Integer id){

        return this.empregadoService.getEmpregado(id);
    }

    // Salvar/Criar empregado
    @PostMapping("/empregados")
    public Empregado criarEmpregado(@Valid @RequestBody EmpregadoDTO dto) {
        Empregado novoEmpregado = this.empregadoService.criarEmpregado(dto);
        return novoEmpregado;
    }

    // Atualizar
    @PutMapping("/empregados/{id}")
    public Empregado atualizar(@PathVariable Integer id, @Valid @RequestBody EmpregadoDTO dto){
        Empregado atualizado = this.empregadoService.atualizar(id, dto);
        return atualizado;
    }

    // Deletar
    @DeleteMapping("/empregados/{id}")
    public void deletar(@PathVariable Integer id){
        this.empregadoService.deletar(id);
    }


}