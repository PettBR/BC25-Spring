package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// DTO - Data Transfer Object ou Objeto de Transferência de dados
// É útil para validarmos as informações transferidas pleo cliente
public class CargoDTO {

    // @NotBlank → impede que o valor da propriedade seja "", por exemplo
    // Message é o texto da validação
    @NotBlank(message = "O campo nome é obrigatório! Por favor preencha esse campo")
    private String nome;
    @NotBlank(message = "O campo descrição também é obrigatório!")
    private String descricao;

    // Impede que o valor seja null
    @NotNull(message = "O campo salário é obrigatório!")
    @Min(value = 500, message = "Campo salário inválido.")
    @Max(value= 100000, message = "Campo salário inválido.")
    private Double salario;

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
