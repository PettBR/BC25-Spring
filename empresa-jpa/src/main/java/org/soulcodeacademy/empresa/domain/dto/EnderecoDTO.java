package org.soulcodeacademy.empresa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class EnderecoDTO {

    @NotNull(message= "IdEmpregado é obrigatório" )
    private Integer idEmpregado;

    @NotBlank(message= "Cidade é obrigatório" )
    private String cidade;

    @NotBlank(message= "UF é obrigatório" )
    private String uf;


    // Getters e Setters
    public Integer getIdEmpregado(){
        return idEmpregado;
    }

    public void setIdEmpregado(Integer idEndereco){
        this.idEmpregado = idEmpregado;
    }

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getUf(){
        return uf;
    }

    public void setUf(String uf){
        this.uf = uf;
    }

}