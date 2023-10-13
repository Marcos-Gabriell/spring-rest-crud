package br.com.curso.spring.curso.model;


import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    private Long id;

    private String nome;

    private int idade;
}
