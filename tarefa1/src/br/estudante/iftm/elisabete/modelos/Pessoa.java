package br.estudante.iftm.elisabete.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public  abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String email;

    protected LocalDate dataNascimento;

    public Pessoa(){

    }
    public Pessoa(String nome) {
        this.nome = nome;
    }


    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento,formatador);

        this.dataNascimento = dataNascimentoFormatada;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
