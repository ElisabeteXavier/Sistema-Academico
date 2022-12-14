package br.estudante.iftm.elisabete.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Aluno extends Pessoa {
    private String matricula;

    private SituacaoAluno situacaoAluno = SituacaoAluno.NaoEnturmado ;

    public SituacaoAluno getSituacaoAluno() {
        return situacaoAluno;
    }

    public void setSituacaoAluno(SituacaoAluno situacaoAluno) {
        this.situacaoAluno = situacaoAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public Aluno() {

    }

    public Aluno(String matricula) {
        this.matricula = matricula;

    }

    public Aluno(String nome, String matricula, String telefone, String cpf, String email, String dataNascimento) {

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento, formatador);


        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimentoFormatada;
    }

    public String toString() {

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\nAluno: " + nome +
                "\n matricula= " + matricula +
                "\n cpf= " + cpf +
                "\n telefone= " + telefone +
                "\n email= " + email +
                "\n Data de Nascimento= " + dataNascimento.format(formatador) +
                "\n Situação do Aluno = " + situacaoAluno;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
