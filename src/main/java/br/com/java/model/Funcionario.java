package br.com.java.model;

import javax.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "nome")
    private String nome;

    @Column(name="sobreNome")
}
