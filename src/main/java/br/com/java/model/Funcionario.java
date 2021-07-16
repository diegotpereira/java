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
    private String sobreNome;

    @Column(name="email_id")
    private String emailId;

    public Funcionario() {
    }

    public Funcionario(String nome, String sobreNome, String emailId) {
        super();
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }    
}
