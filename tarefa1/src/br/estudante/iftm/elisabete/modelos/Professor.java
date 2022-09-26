package br.estudante.iftm.elisabete.modelos;

import java.util.Objects;

public class Professor extends Pessoa {

    private int registro;

    public Professor() {
    }

    public Professor(int registro) {
        this.registro = registro;

    }

    public Professor(String nome, int registro, String telefone, String cpf, String email) {
        this.nome = nome;
        this.registro = registro;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;


    }


    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String toString() {
        return "PROFESSOR{" +
                "\nregistro= " + registro +
                "\n nome= " + nome +
                "\n cpf= " + cpf +
                "\n telefone= " + telefone +
                "\n email= " + email +
                "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return registro == professor.registro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registro);
    }
}