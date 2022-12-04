package org.soulcodeacademy.empresa.domain.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpregadoDTO {
    @NotNull(message = "IdProjeto é obrigatório")
    private Integer IdProjeto;

    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Salário é Obrigatório")
    private Double salario;

    // Getters e Setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
}

