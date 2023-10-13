package br.com.curso.spring.curso.model;


import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    private Long id;

    private String nome;

    private int idade;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
