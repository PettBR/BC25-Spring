package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente extends Usuario {

    @Column
    private String telefone;

    // Construtores
    public Cliente() {}

    public Cliente(Integer id, String nome, String email, String cpf, String senha, String telefone) {
        super(id, nome, email, cpf, senha, Perfil.CLIENTE);
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
