package org.soulcodeacademy.empresa.controllers;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping("/enderecos")
    public List<Endereco> listar() {
        // Requisição -> Controller -> Service -> Repository -> SELECT * FROM endereco;
        return this.enderecoService.listar(); // JSON = JAVASCRIPT OBJECT NOTATION
    }

    @GetMapping("/enderecos/{idEndereco}") // indica que o valor após a barra é dinâmico!
    public Endereco getEndereco(@PathVariable Integer idEndereco) {
        // @PathVariable => extrai do endpoint o valor dinâmico
        return this.enderecoService.getEndereco(idEndereco);
    }

    // Podemos usar o mesmo endpoint para verbos diferentes
    @PostMapping("/enderecos") // REQUISIÇÃO TIPO POST para /enderecos
    public Endereco salvar(@Valid @RequestBody EnderecoDTO endereco) {
        // @RequestBody - extrair o JSON do corpo e converte para Endereco (deserialização)
        Endereco salvo = this.enderecoService.salvar(endereco);
        return salvo; // A resposta será o endereco inserido
    }

    // Mapeia requisições do verbo PUT
    @PutMapping("/enderecos/{idEndereco}") // /enderecos/5
    public Endereco atualizar(@PathVariable Integer idEndereco, @Valid @RequestBody EnderecoDTO endereco) {
        Endereco atualizado = this.enderecoService.atualizar(idEndereco, endereco);
        return atualizado; // Resposta para o cliente (endereco atualizado)
    }

    @DeleteMapping("/enderecos/{idEndereco}") // Verbo DELETE no /endereco/1
    public void deletar(@PathVariable Integer idEndereco) {
        this.enderecoService.deletar(idEndereco);
    }
}